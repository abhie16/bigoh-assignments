from pydantic import BaseModel

class Task(BaseModel):
    task_id:int
    task:str

    class Config:
        from_attributes = True

class User(BaseModel):
    id: int
    name: str
    tasks: list[Task] = []

    class Config:
        from_attributes = True