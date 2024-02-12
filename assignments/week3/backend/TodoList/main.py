import controller

from fastapi import FastAPI
from fastapi_router_controller import Controller
from utils.middleware.log_incoming_request import LogIncomingRequest
from controller.sample_controller import TodoController


app = FastAPI()


app.add_middleware(LogIncomingRequest)

# Configure all the implemented
# controllers in the main app
for router in Controller.routers():
    print(router)
    app.include_router(router)

