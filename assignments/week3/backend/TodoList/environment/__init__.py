# pathlib is a module that provides an object-oriented 
# interface for working with the file system, Path is a 
# class that represents the file system path.
from pathlib import Path

# this dir is the current directory of the file example is 
# environment/__init__.py
this_dir = Path(__file__).parent

# dev, stage, and prod are the environment files that we
# will use to set the environment variables
dev = this_dir / 'env/dev.env'
stage = this_dir / 'env/stage.env'
prod = this_dir / 'env/prod.env'