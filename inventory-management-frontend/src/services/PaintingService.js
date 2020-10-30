import axios from 'axios';

const Painting_API_BASE_URL = "http://localhost:8080/api/v1/paintings";

class PaintingService {

    getPaintings() {
        return axios.get(Painting_API_BASE_URL);
    }
}

export default new PaintingService();