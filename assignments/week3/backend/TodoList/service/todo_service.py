from fastapi import Depends
from utils.logger import Logger

from schema.task_schema import Task, User
from repository.db_utils import TodoRepository

logger = Logger.get_logger(__name__)

class TodoService:
    def __init__(self, todo_repository: TodoRepository = Depends()) -> None:
        self.todo_repository = todo_repository

    def get_user(self, user_id:int):
        logger.debug(f'Getting user with id {user_id}')
        return self.todo_repository.get_user(user_id)

    def get_users(self, skip: int=0, limit: int=100):
        logger.debug(f'Getting users with skip {skip} and limit {limit}')
        return self.todo_repository.get_users(skip, limit)

    def create_user(self, user: User):
        logger.debug(f'Creating user with name {user.name}')
        return self.todo_repository.create_user(user)

    def create_user_task(self, task: Task, user_id:int):
        logger.debug(f'Creating task for user with id {user_id}')
        return self.todo_repository.create_user_task(task, user_id)

    def get_user_task(self , user_id:int, task_id:int):
        logger.debug(f'Getting task with id {task_id} for user with id {user_id}')
        return self.todo_repository.get_user_task(user_id, task_id)

    def get_user_tasks(self, user_id:int, skip:int=0, limit:int=100):
        logger.debug(f'Getting tasks for user with id {user_id} with skip {skip} and limit {limit}')
        return self.todo_repository.get_user_tasks(user_id, skip, limit)
    
    def delete_user(self, user_id:int):
        logger.debug(f'Deleting user with id {user_id}')
        self.todo_repository.delete_user(user_id)
    
    def update_user_task(self, task: Task, user_id:int):
        logger.debug(f'Updating task with id {task.id} for user with id {user_id}')
        return self.todo_repository.update_user_task(task, user_id)
    
    def delete_user_task(self, user_id:int, task_id:int):
        logger.debug(f'Deleting task with id {task_id} for user with id {user_id}')
        self.todo_repository.delete_user_task(user_id, task_id)
