from fastapi import Depends
from sqlalchemy.orm import Session
from utils.db_connection import get_db_session
from utils.logger import Logger

from model.user_model import User
from schema.user_schema import UserSchema

logger = Logger.get_logger(__name__)

class UserRepository:
    def __init__(self, db: Session = Depends(get_db_session)):
        self.db = db

    def get_users(self, skip: int = 0, limit: int = 10):
        logger.debug('get_users - start')
        return self.db.query(User).offset(skip).limit(limit).all()

    def get_user(self, user_id: int):
        logger.debug('get_user - start')
        return self.db.query(User).filter(User.id == user_id).first()

    def create_user(self, user: UserSchema):
        logger.debug('create_user - start')
        db_user = User(id=user.id, name=user.name,phone_number= user.phone_number)
        self.db.add(db_user)
        self.db.commit()
        self.db.refresh(db_user)
        return db_user
    
    def add_contact(self, user_id: int, contact_id: int):
        logger.debug('add_contact - start')
        user = User.contacts(user_id, contact_id)
        self.db.add(user)
        self.db.commit()
        self.db.refresh(user)
        return user
    
    def get_contacts(self, user_id: int):
        logger.debug('get_contacts - start')
        contacts = self.db.query(User.contacts).filter(User.id == user_id).all()
        return contacts

    # def update_user(self, user_id: int, user: dict):
    #     return {"user_id": user_id, **user}

    # def delete_user(self, user_id: int):
    #     return {"user_id": user_id}