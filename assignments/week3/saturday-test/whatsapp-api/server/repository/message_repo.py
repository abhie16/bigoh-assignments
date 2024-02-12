from fastapi import Depends
from sqlalchemy.orm import Session
from utils.db_connection import get_db_session
from utils.logger import Logger

from model.message_model import Message
from schema.message_schema import MessageSchema

logger = Logger.get_logger(__name__)

class MessageRepository:
    def __init__(self, db: Session = Depends(get_db_session)):
        self.db = db
    
    def get_messages(self, user_id:int, skip: int = 0, limit: int = 10):
        logger.debug('get_messages - start')
        return self.db.query(Message).filter(Message.reciever_id == user_id).offset(skip).limit(limit).all()
    
    def create_text_message(self, message: MessageSchema):
        logger.debug('create_text_message - start')
        db_message = Message(id = message.id, content=message.msg_content , reciever_id = message.receiver_id , sender_id= message.sender_id)
        self.db.add(db_message)
        self.db.commit()
        self.db.refresh(db_message)
        return db_message

    def create_voice_message(self, message: MessageSchema):
        logger.debug('create_voice_message - start')
        db_message = Message(id = message.id, content=message.msg_content , reciever_id = message.receiver_id , sender_id= message.sender_id)
        self.db.add(db_message)
        self.db.commit()
        self.db.refresh(db_message)
        return db_message
    
    def create_image_message(self, message: MessageSchema):
        logger.debug('create_image_message - start')
        db_message = Message(id = message.id, content=message.msg_content , reciever_id = message.receiver_id , sender_id= message.sender_id)
        self.db.add(db_message)
        self.db.commit()
        self.db.refresh(db_message)
        return db_message
    
    def create_video_message(self, message: MessageSchema):
        logger.debug('create_message - start')
        db_message = Message(id = message.id, content=message.msg_content , reciever_id = message.receiver_id , sender_id= message.sender_id)
        self.db.add(db_message)
        self.db.commit()
        self.db.refresh(db_message)
        return db_message
    
    def delete_message(self, message_id: int):
        logger.debug('delete_message - start')
        message = self.db.query(Message).filter(Message.id == message_id).first()
        if message:
            self.db.delete(message)
            self.db.commit()
            return message
        return None
