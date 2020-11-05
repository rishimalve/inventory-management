import React, { Component } from 'react'
import PaintingService from '../services/PaintingService';

export default class AddPaintingForm extends Component {

    initialState = {
        name: '',
        type: '',
        dimensions: '',
        imgPath: '',
        price: null,
        medium: ''
    }

    state = this.initialState

    changeHandler = (event) => {
        const { name, value } = event.target;

        this.setState({
            [name]: value
        });

    }

    submitForm = (event) => {
        event.preventDefault();
        PaintingService.uploadPainting(this.state).then(res => {
            this.props.history.push('/paintings')
        });
    }

    resetForm = (event) => {
        this.setState(this.initialState);
    }

    render() {
        const painting = this.state
        return (
            <div className="small-container">
                <h2>Enter Painting Details</h2>
                <div className="flex-row">
                    <div className="flex-large">
                        <form onSubmit={this.submitForm} onReset={this.resetForm}>
                            <input type="text" placeholder="Name"
                                name="name"
                                id="name"
                                value={painting.name}
                                onChange={this.changeHandler}
                                required />
                            <div className="d-flex">
                                <input type="text" placeholder="Type"
                                    name="type"
                                    id="type"
                                    value={painting.type}
                                    onChange={this.changeHandler}
                                    required /> &nbsp;&nbsp;&nbsp;&nbsp;
                                <input type="text" placeholder="Medium"
                                    name="medium"
                                    id="meduim"
                                    value={painting.medium}
                                    onChange={this.changeHandler}
                                    required />
                            </div>
                            <div className="d-flex">
                                <input type="text" placeholder="Dimensions"
                                    name="dimensions"
                                    id="dimensions"
                                    value={painting.dimensions}
                                    onChange={this.changeHandler}
                                    required /> &nbsp;&nbsp;&nbsp;&nbsp;
                                <input type="number" placeholder="Price"
                                    name="price"
                                    id="price"
                                    value={painting.price}
                                    onChange={this.changeHandler}
                                    required />
                            </div>
                            <input type="text" placeholder="Image"
                                name="imgPath"
                                id="imgPath"
                                value={painting.imgPath}
                                onChange={this.changeHandler}
                                required />
                            <br />
                            <button type="submit" className="button">Add Painting</button>
                            <button type="reset" className="button muted-button">Cancel</button>
                        </form>
                    </div>
                </div>
            </div >
        )
    }
}
