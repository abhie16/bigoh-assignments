from pydantic import BaseModel

class MessageSchema(BaseModel):
    """ This provide a schema for the message object."""
    id: int
    sender_id: int
    receiver_id: int
    type: str
    msg_content: str