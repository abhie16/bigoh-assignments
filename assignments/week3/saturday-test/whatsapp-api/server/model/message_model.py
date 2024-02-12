from sqlalchemy import Column, ForeignKey, Integer, String
from sqlalchemy.orm import relationship

from utils.db_connection import Base
from utils.db_connection import engine


class Message(Base):
    __tablename__ = "messages"

    id = Column(Integer, primary_key=True, index=True)
    content = Column(String, index=True)
    sender_id = Column(Integer)
    reciever_id = Column(Integer, ForeignKey("users.id"))

    reciever = relationship("User", back_populates="recieved_messages")


Base.metadata.create_all(bind=engine)