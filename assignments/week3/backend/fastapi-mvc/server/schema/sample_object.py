from pydantic import BaseModel, Field

class SampleObject(BaseModel):
    id: str = Field(..., min_length=3, max_length=50)

    class Config:
        orm_mode = True
