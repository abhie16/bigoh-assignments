from fastapi import Depends

from repository.message_repo import MessageRepository

from schema.message_schema import MessageSchema

from utils.logger import Logger

logger = Logger.get_logger(__name__)

class MessageService():
    def __init__(self, repository: MessageRepository = Depends()):
        self.repository = repository

    def get_messages(self, user_id:int):
        logger.debug('get_messages - start')
        return self.repository.get_messages(user_id)

    def create_text_message(self, message: MessageSchema):
        logger.debug('create_message - start')
        return self.repository.create_text_message(message)
    
    def create_voice_message(self, message: MessageSchema):
        logger.debug('create_message - start')
        return self.repository.create_voice_message(message)
    
    def create_image_message(self, message: MessageSchema):
        logger.debug('create_message - start')
        return self.repository.create_image_message(message)
    
    def create_video_message(self, message: MessageSchema):
        logger.debug('create_message - start')
        return self.repository.create_video_message(message)
    
    def delete_message(self, message_id: int):
        logger.debug('delete_message - start')
        return self.repository.delete_message(message_id)