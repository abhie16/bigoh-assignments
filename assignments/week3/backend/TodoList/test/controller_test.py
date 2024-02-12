import mock
from unittest import TestCase
from fastapi.testclient import TestClient
from main import app
from alchemy_mock.mocking import AlchemyMagicMock

client = TestClient(app)
mock_db_session = AlchemyMagicMock()

def get_mock_session():
    return mock_db_session

class SampleControllerTest(TestCase):
    
    def setUp(self):
        self.client = client

    def test_create_user(self):
        response = self.client.post("/user/create", json={"id": 7, "name": "user7"})
        assert response.status_code == 200
        assert response.json() == {"id": 7, "name": "user7"}

    def test_get_user(self):
        response = self.client.get("/user/7")
        assert response.status_code == 200
        assert response.json() == {"id": 7, "name": "user7"}

    def test_create_item(self):
        response = self.client.post("/user/7/create", json={"task_id": 1, "task": "task1"})
        assert response.status_code == 200
        assert response.json() == {"id": 1, "task": "task1", "owner_id": 7}
    
    def test_read_item(self):
        response = self.client.get("/user/7/task/1")
        assert response.status_code == 200
        assert response.json() == {"id": 1, "task": "task1", "owner_id": 7}

    def test_read_all(self):
        response = self.client.get("/user/7/tasks")
        assert response.status_code == 200
        assert response.json() == [{"id": 1, "task": "task1", "owner_id": 7}]

    def test_update_item(self):
        reponse = self.client.put('/user/7/update', json={"task_id": 1, "task": "task1 updated"})
        assert reponse.status_code == 200
        assert reponse.json() == [{"id": 1, "task": "task1 updated", "owner_id": 7}]

    def test_delete_item(self):
        response = self.client.delete("/user/7/delete/1")
        assert response.status_code == 200
        assert response.json() == {"message": "Task deleted successfully"}
    
    def test_delete_user(self):
        response = self.client.delete("/user/7")
        assert response.status_code == 200
        assert response.json() == {"message": "User deleted successfully"}
    
    
