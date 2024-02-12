import os
from fastapi import APIRouter

# get the current environment from the environment variable 
current_environment = os.environ.get('env_name')

# get the sample controller path from the environment variable
__sample_path = os.environ.get('sample_controller')

# create a router for the sample controller
sample_router = APIRouter(prefix=__sample_path)