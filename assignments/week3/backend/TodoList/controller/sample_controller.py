from fastapi import APIRouter, HTTPException, Depends
from service.todo_service import TodoService

from schema.task_schema import Task,User
from schema.errors import Errors, ErrorModel
from model import models
from utils.db import engine
from utils.logger import Logger

from fastapi_router_controller import Controller

logger = Logger.get_logger(__name__)

models.Base.metadata.create_all(bind=engine)


todo_router = APIRouter(prefix='/user')

controller = Controller(todo_router)

# Mark TodoController Class to use it automatically
@controller.use()
# Mark TodoController Class as resource of the given Controller router
@controller.resource()
class TodoController():
    def __init__(self, service:TodoService = Depends()):
        self.service = service
         
    # crud app #

    ## checked
    #post user
    @controller.route.post(
            "/create",
            tags=["controller"],
            summary="Create a new user",
            response_model=User,
            responses={
                Errors.HTTP_404_NOT_FOUND.status_code : {'model': ErrorModel, 'description': 'Bad Request'},
                Errors.HTTP_500_INTERNAL_SERVER_ERROR.status_code: {'model': ErrorModel, 'description': 'Internal Server Error'}
            })
    def create_user(self, user:User):
        try:
            return self.service.create_user(user)
        except:
            logger.error('Error while creating user')
            return Errors.HTTP_500_INTERNAL_SERVER_ERROR
        
    
    ## checked
    #get user
    @controller.route.get("/{user_id}")
    def get_user(self, user_id:int):
        try:
            user = self.service.get_user(user_id)
            if user is None:
                raise HTTPException(status_code=404, detail="User not found")
            return user
        except:
            logger.error(f'Error while finding user wih id {user_id}')
            raise HTTPException(status_code=404, detail="Error while finding user")

    ## checked
    #get all user
    @controller.route.get("")
    def get_all_user(self, skip:int=0, limit:int=100):
        try:
            users = self.service.get_users(skip, limit)
            return users
        except:
            logger.error('Error while finding users')
            raise HTTPException(status_code=404, detail="Error while finding users")
    
    #delete user with user id
    @controller.route.delete("/{user_id}")
    def delete_user(self, user_id:int):
        try:
            self.service.delete_user(user_id)
            return {"message": "User deleted successfully"}
        except:
            logger.error(f'Error while deleting user with id {user_id}')
            raise HTTPException(status_code=404, detail="User not found")

    # checked
    # post
    @controller.route.post("/{user_id}/create")
    def create_item(self, user_id:int, task: Task):
        try:
            return self.service.create_user_task(task, user_id)
        except:
            logger.error(f'Error while creating task for user with id {user_id}')
            raise HTTPException(status_code=400, detail="Error while creating task")

    #get
    ## get task on basis of task id
    @controller.route.get("/{user_id}/task/{task_id}")
    def read_item(self,user_id:int, task_id:int):
        try:    
            task = self.service.get_user_task(user_id, task_id)
            if task is None:
                raise HTTPException(status_code=404, detail="Task not found")
            return task
        except:
            logger.error(f'Error while finding task with id {task_id} for user with id {user_id}')
            raise HTTPException(status_code=400, detail="Error while finding task")
        
    ## checked
    ## get all task when no id provided
    @controller.route.get("/{user_id}/tasks")
    def read_all(self, user_id:int):
        try:
            tasks = self.service.get_user_tasks(user_id)
            return tasks
        except:
            logger.error(f'Error while finding tasks for user with id {user_id}')
            raise HTTPException(status_code=500, detail="Error while finding tasks")
        

    #checked
    # put
    @controller.route.put("/{user_id}/update")
    def update_item(self, user_id:int,newTask:Task):
        try:
            task = self.service.update_user_task(newTask,user_id)
            if task is None:
                raise HTTPException(status_code=404, detail="Task not found")
            return task
        except:
            logger.error(f'Error while updating task with id {newTask.id} for user with id {user_id}')
            raise HTTPException(status_code=500, detail="Error while updating task")
        
    #checked
    # delete
    @controller.route.delete("/{user_id}/delete/{task_id}")
    def delete_item(self, user_id:int, task_id:int): 
        try:
            self.service.delete_user_task(user_id, task_id)
            return {"message": "Task deleted successfully"}
        except:
            logger.error(f'Error while deleting task with id {task_id} for user with id {user_id}')
            raise HTTPException(status_code=500, detail="Task not found")

