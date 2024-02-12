from pydantic import BaseModel

class StatusSchema(BaseModel):
    """ This provide a schema for the status object."""
    id: int
    user_id: int

    class Config:
        orm_mode = True

# The following classes are subclasses of the StatusSchema class. Using Factory Method pattern,
# we can create different types of status.

class TextStatusSchema(StatusSchema):
    """ provide a schema for the text status object."""
    text_status: str

class ImageStatusSchema(StatusSchema):
    """ provide a schema for the Image status object."""
    image_status: str

