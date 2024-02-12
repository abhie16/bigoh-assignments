from fastapi import APIRouter, Depends, HTTPException
from fastapi_router_controller import Controller

from utils.logger import Logger
from service.message_service import MessageService

from schema.message_schema import MessageSchema

message_router = APIRouter(prefix="/message", tags=["Message"])
logger = Logger.get_logger(__name__)

controller = Controller(message_router)

@controller.use()
@controller.resource()
class MessageController():
    def __init__(self, service: MessageService = Depends()):
        self.service = service

    def __get_method(self, message: MessageSchema):
        if message.type == "text":
            return self.service.create_text_message
        elif message.type == "voice":
            return self.service.create_voice_message
        elif message.type == "image":
            return self.service.create_image_message
        elif message.type == "video":
            return self.service.create_video_message
        else:
            raise HTTPException(status_code=400, detail="Invalid message type")
        
    @controller.route.get("/{user_id}")
    def get_messages(self, user_id:int):
        try:
            logger.debug('get_messages - start')
            messages = self.service.get_messages(user_id)
            if messages is None:
                raise HTTPException(status_code=404, detail="No Messages found")
            return messages
        except Exception as e:
            logger.error(f'get_messages - {e}')
            raise HTTPException(status_code=500, detail="Internal Server Error")
        
        
    @controller.route.post("")
    def create_message(self, message: MessageSchema):
        try:
            logger.debug(f'create_{message.type}_message - start')
            send_message = self.__get_method(message)
            return send_message(message)
        except Exception as e: 
            logger.error(f'create_{message.type}_message - {e}')
            raise HTTPException(status_code=500, detail="Internal Server Error")
        
    @controller.route.delete("/delete/{message_id}")
    def delete_message(self, message_id: int):
        try:
            logger.debug('delete_message - start')
            message = self.service.delete_message(message_id)
            if message is None:
                raise HTTPException(status_code=404, detail="Message not found")
            return message
        except Exception as e:
            logger.error(f'delete_message - {e}')
            raise HTTPException(status_code=500, detail="Internal Server Error")