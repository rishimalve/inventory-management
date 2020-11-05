import React, { Component } from 'react';
import { NavLink } from "react-router-dom";
import { Navbar, Nav, NavDropdown } from 'react-bootstrap';

export default class Header extends Component {

    constructor(props) {
        super(props)

        this.state = {

        }
        this.allPaintings = this.allPaintings.bind(this);
    }

    allPaintings() {
        this.props.history.push('/paintings');
    }

    render() {
        return (
            <div>
                <header>
                    <Navbar className="navbar navbar-expand-md navbar-dark bg-dark">
                        <NavLink exact activeClassName="active" className="navbar-brand" to="/">Painting Inventory Management</NavLink>
                        <Navbar.Toggle aria-controls="basic-navbar-nav" />
                        <Navbar.Collapse id="basic-navbar-nav">
                            <Nav className="mr-auto">
                                <Nav.Link href="/paintings">List</Nav.Link>
                                <NavDropdown title="Add Paintings" id="basic-nav-dropdown">
                                    <NavDropdown.Item href="/add-single-painting">Single Painting</NavDropdown.Item>
                                    <NavDropdown.Item href="#action/3.2">Upload a File</NavDropdown.Item>
                                </NavDropdown>
                            </Nav>
                        </Navbar.Collapse>
                    </Navbar>
                </header>
            </div>
        )
    }
}
