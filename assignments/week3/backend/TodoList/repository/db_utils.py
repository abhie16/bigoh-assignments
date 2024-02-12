from fastapi import Depends
from sqlalchemy.orm import Session
from utils.db import get_db_session
from utils.logger import Logger

from schema import task_schema
from model import models

logger = Logger.get_logger(__name__)

class TodoRepository:
    def __init__(self, db_session: Session = Depends(get_db_session)) -> None:
        self.db = db_session

    def get_user(self, user_id:int):
        logger.debug(f'Getting user with id {user_id}')
        return self.db.query(models.User).filter(models.User.id == user_id).first()

    def get_users(self, skip: int=0, limit: int=100):
        logger.debug(f'Getting users with skip {skip} and limit {limit}')
        return self.db.query(models.User).offset(skip).limit(limit).all()

    def create_user(self, user: task_schema.User):
        logger.debug(f'Creating user with name {user.name}')
        db_user = models.User(id=user.id,name=user.name)
        self.db.add(db_user)
        self.db.commit()
        self.db.refresh(db_user)
        return db_user

    def create_user_task(self, task: task_schema.Task, user_id:int):
        logger.debug(f'Creating task for user with id {user_id}')
        db_item = models.Task(id=task.task_id, task=task.task, owner_id = user_id)
        self.db.add(db_item)
        self.db.commit()
        self.db.refresh(db_item)
        return db_item

    def get_user_task(self, user_id:int, task_id:int):
        logger.debug(f'Getting task with id {task_id} for user with id {user_id}')
        return self.db.query(models.Task).filter(models.Task.owner_id == user_id, models.Task.id == task_id).first()

    def get_user_tasks(self, user_id:int, skip:int=0, limit:int=100):
        logger.debug(f'Getting tasks for user with id {user_id} with skip {skip} and limit {limit}')
        return self.db.query(models.Task).filter(models.Task.owner_id == user_id).offset(skip).limit(limit).all()
    
    def delete_user(self, user_id:int):
        logger.debug(f'Deleting user with id {user_id}')
        user = self.db.query(models.User).filter(models.User.id == user_id).first()
        self.db.delete(user)
        self.db.delete(models.Task).filter(models.Task.owner_id == user_id).all()
        self.db.commit()
    
    def update_user_task(self, task: task_schema.Task, user_id:int):
        logger.debug(f'Updating task with id {task.id} for user with id {user_id}')
        db_task = self.db.query(models.Task).filter(models.Task.owner_id == user_id, models.Task.id == task.task_id).first()
        db_task.task = task.task
        self.db.commit()
        self.db.refresh(db_task)
        return db_task
    
    def delete_user_task(self, user_id:int, task_id:int):
        logger.debug(f'Deleting task with id {task_id} for user with id {user_id}')
        task = self.db.query(models.Task).filter(models.Task.owner_id == user_id, models.Task.id == task_id).first()
        self.db.delete(task)
        self.db.commit()

