from fastapi.responses import JSONResponse
from fastapi import APIRouter, status, Query, Body, Depends
from fastapi_router_controller import Controller
from utils.logger import Logger
from schema.errors import Errors, ErrorModel, throw_error
from schema.sample_object import SampleObject
from service.sample_service import SampleService
logger = Logger.get_logger(__name__)
from environment import router


# //Validation ModuleNotFoundError
# //versioning
# //ROute - Control Annotation...or Routes.

# /api/v1/ - SampleController - ?? Node or Django

# //env is used for external api - downstream and upstream

# //multiple SampleService


# api/v1/user/5/role

# userservice
# RoleService


# //controller level - annotation required..400
# //validator or model...
# remove service
# create a controller descriptor and pass the router to bind
controller = Controller(router.sample_router, openapi_tag={
    'name': 'sample-controller',
})

# Mark SampleController Class to use it automatically
@controller.use()
# Mark SampleController Class as resource of the given Controller router
@controller.resource()
class SampleController():
    def __init__(
        self,
        # The service istance is injected by FastApi
        service: SampleService = Depends()) -> None:
        self.service = service


# //logic..
    @controller.route.get(
        '',
        tags=['sample-controller'], 
        summary='Get Object from DB', 
        response_model=SampleObject,
        responses={
            Errors.HTTP_404_NOT_FOUND.status_code: { 'model': ErrorModel, 'description': 'Item not found on DB' },
            Errors.HTTP_500_INTERNAL_SERVER_ERROR.status_code: { 'model': ErrorModel, 'description': 'Generic Error Occured' }
        })
    def get_sample_object(
        self,
        id: str = Query(
            ...,
            title="itemId",
            description="The id of the item to get")):
        try:
            item = self.service.get_by_id(id)

            if item is None:
                return Errors.HTTP_404_NOT_FOUND

            # return the item whithout specify the response type, json is the default
            # 200 is used as default status code
            return item
        except Exception as error:
            logger.error('Error getting item: {}'.format(error))
            return Errors.HTTP_500_INTERNAL_SERVER_ERROR

    @controller.route.post(
        '',
        tags=['sample-controller'], 
        summary='Intert a new Item on DB.', 
        status_code=201,
        response_description='The item was created on DB. No body is provided',
        responses={
            Errors.HTTP_500_INTERNAL_SERVER_ERROR.status_code: { 
                'model': ErrorModel, 'description': 'Generic Error Occured' }
        })
    def add_sample_object(
        self,
        sample_object: SampleObject = Body(
            ..., 
            title="Item", 
            description="The item object to store")):
        try:
            self.service.insert(sample_object)

            return JSONResponse(status_code=status.HTTP_201_CREATED, content= {'message': "added successfully"})
        except Exception as error:
            logger.error('Error inserting item: {}'.format(error))
            return throw_error(status= status.HTTP_500_INTERNAL_SERVER_ERROR, message= "Internal Server Error", error_code= 5000, error= error)
