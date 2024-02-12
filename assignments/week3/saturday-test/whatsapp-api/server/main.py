import controller

from fastapi import FastAPI
from fastapi_router_controller import Controller
from controller.user_controller import UserController
from controller.message_controller import MessageController


app = FastAPI()


for router in Controller.routers():
    app.include_router(router)