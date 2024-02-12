from fastapi import APIRouter, Depends, HTTPException
from fastapi_router_controller import Controller

from utils.logger import Logger
from service.user_service import UserService

from schema.user_schema import UserSchema

user_router = APIRouter(prefix="/user", tags=["User"])
logger = Logger.get_logger(__name__)

controller = Controller(user_router)

@controller.use()
@controller.resource()
class UserController():
    def __init__(self, service:UserService = Depends()):
        self.service = service

    @controller.route.get("")
    def get_users(self):
        try:
            logger.debug('get_users - start')
            return self.service.get_users()
        except Exception as e:
            logger.error(f'get_users - {e}')
            raise HTTPException(status_code=500, detail="Internal Server Error")

    @controller.route.get("/{user_id}")
    def get_user(self, user_id: int):
        try:
            logger.debug('get_user - start')
            user = self.service.get_user(user_id)
            if user is None:
                raise HTTPException(status_code=404, detail="User not found")
            return user
        except Exception as e:
            logger.error(f'get_user - {e}')
            raise HTTPException(status_code=500, detail="Internal Server Error")

    @controller.route.post("")
    def create_user(self, user: UserSchema):
        try:
            logger.debug('create_user - start')
            return self.service.create_user(user)
        except Exception as e:
            logger.error(f'create_user - {e}')
            raise HTTPException(status_code=500, detail="Internal Server Error")
        
    @controller.route.post("/addContact/{user_id}/{contact_id}")
    def add_contact(self, user_id: int, contact_id: int):
        try:
            logger.debug('add_contact - start')
            return self.service.add_contact(user_id, contact_id)
        except Exception as e:
            logger.error(f'add_contact - {e}')
            raise HTTPException(status_code=500, detail="Internal Server Error")
        
    @controller.route.get("/contacts/{user_id}")
    def get_contacts(self, user_id: int):
        try:
            logger.debug('get_contacts - start')
            contacts = self.service.get_contacts(user_id)
            if contacts is None:
                raise HTTPException(status_code=404, detail="No contacts found")
            return contacts
        except Exception as e:
            logger.error(f'get_contacts - {e}')
            raise HTTPException(status_code=500, detail="Internal Server Error")
    

        

    # @controller.route.put("/{user_id}")
    # def update_user(self, user_id: int, user: dict):
    #     return {"user_id": user_id, **user}

    # @controller.route.delete("/{user_id}")
    # def delete_user(self, user_id: int):
    #     return {"user_id": user_id}