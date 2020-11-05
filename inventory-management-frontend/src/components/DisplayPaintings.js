import React, { Component } from 'react'
import PaintingService from '../services/PaintingService'

export default class DisplayPaintings extends Component {

    constructor(props) {
        super(props)

        this.state = {
            paintings: []
        }
    }

    componentDidMount() {
        PaintingService.getPaintings().then((response) => {
            this.setState({paintings : response.data})
        });
    }

    render() {
        return (
            <div>
                <h2 className="text"> Paintings Inventory </h2>
                <div>
                    <table className="striped-table">
                        <thead>
                            <tr>
                                <th>Name</th>
                                <th>Type</th>
                                <th>Medium</th>
                                <th>Dimensions</th>
                                <th>Image</th>
                                <th>Price</th>
                                <th>Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            {
                                this.state.paintings.map(
                                    painting =>
                                    <tr key={painting.id}>
                                        <td>{painting.name}</td>
                                        <td>{painting.type}</td>
                                        <td>{painting.medium}</td>
                                        <td>{painting.dimensions}</td>
                                        <td>{painting.imgPath}</td>
                                        <td>{painting.price}</td>
                                        <td>
                                            <button className="button">Edit</button>
                                            <button className="button">Delete</button>
                                        </td>
                                    </tr>
                                )
                            }
                        </tbody>
                    </table>
                </div>
            </div>
        )
    }
}
