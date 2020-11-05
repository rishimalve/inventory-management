import axios from 'axios';

const Painting_API_BASE_URL = "http://localhost:8080/api/v1/";

class PaintingService {

    getPaintings() {
        return axios.get(Painting_API_BASE_URL + "/paintings");
    }

    uploadPainting(painting) {
        return axios.post(Painting_API_BASE_URL + "/add/single-painting", painting);
    }
}

export default new PaintingService();