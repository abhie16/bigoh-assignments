from sqlalchemy import Column, ForeignKey, Integer, String
from sqlalchemy.orm import relationship

from utils.db_connection import Base
from utils.db_connection import engine


class User(Base):
    __tablename__ = "users"

    id = Column(Integer, primary_key=True)
    name = Column(String, unique=True, index=True)
    phone_number = Column(String, unique=True, index=True)
    
    recieved_messages = relationship("Message", back_populates="reciever")


Base.metadata.create_all(bind=engine)