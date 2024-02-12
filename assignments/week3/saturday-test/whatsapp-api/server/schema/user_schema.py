from pydantic import BaseModel

class UserSchema(BaseModel):
    """ This provide a schema for the user object."""
    id: int
    name: str
    phone_number: str
    all_contacts : list[int] = []