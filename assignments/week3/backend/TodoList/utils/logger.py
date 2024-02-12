import logging

from utils.config import Config
from environment import router


class Logger():
    CONFIG_KEY = 'log'

    @staticmethod
    def get_level():
        if router.current_environment == "dev": return "DEBUG"
        elif router.current_environment == "prod": return "INFO"

        # default
        # if the environment is not dev or prod, we will use the
        # value from the configuration file
        return Config.read(Logger.CONFIG_KEY, "level")
    
    # get the filename from the configuration file
    @staticmethod
    def get_filename():
        return Config.read(Logger.CONFIG_KEY, "filename") # this will return the value of the key filename from the log section in the configuration file
    
    # get the format from the configuration file
    @staticmethod
    def get_format():
        return Config.read(Logger.CONFIG_KEY, "format") # this will return the value of the key format from the log section in the configuration file
    
    # get the date format from the configuration file
    @staticmethod
    def get_date_format():
        return Config.read(Logger.CONFIG_KEY, "dateformat") # this will return the value of the key date_format from the log section in the configuration file
    

    @staticmethod
    def get_logger(name):
        # create a logger
        logger = logging.getLogger(name)
        # set the level of the logger
        logger.setLevel(Logger.get_level())

        # create a formatter
        formatter = logging.Formatter(
            Logger.get_format(),
            Logger.get_date_format()
        )

        # create a file handler
        file_hdlr = logging.FileHandler(Logger.get_filename())
        file_hdlr.setFormatter(formatter)
        logger.addHandler(file_hdlr)

        return logger