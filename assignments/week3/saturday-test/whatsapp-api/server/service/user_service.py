from fastapi import Depends

from repository.user_repo import UserRepository

from schema.user_schema import UserSchema

from utils.logger import Logger

logger = Logger.get_logger(__name__)

class UserService():
    def __init__(self, repository: UserRepository = Depends()):
        self.repository = repository

    def get_users(self):
        logger.debug('get_users - start')
        return self.repository.get_users()

    def get_user(self, user_id: int):
        logger.debug('get_user - start')
        return self.repository.get_user(user_id)

    def create_user(self, user: UserSchema):
        logger.debug('create_user - start')
        return self.repository.create_user(user)
    
    def add_contact(self, user_id: int, contact_id: int):
        logger.debug('add_contact - start')
        return self.repository.add_contact(user_id, contact_id)
    
    def get_contacts(self, user_id: int):
        logger.debug('get_contacts - start')
        return self.repository.get_contacts(user_id)

    # def update_user(self, user_id: int, user: dict):
    #     return {"user_id": user_id, **user}

    # def delete_user(self, user_id: int):
    #     return {"user_id": user_id}