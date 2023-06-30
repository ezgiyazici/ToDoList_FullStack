
// rcc
import React, { Component } from 'react'


import { withTranslation } from 'react-i18next';


// CLASS Component
class Header extends Component {

    // Componentteki yeni isim
    static displayName = "Blog_Header"

    // CONSTRUCTOR
    constructor(props) {
        super(props);

        //bind

        //state
        this.state = {}

        //bind
    }

    // CDM
    componentDidMount() { }

    // FUNCTION

    //RENDER
    render() {

        //RETURN
        return (
            // <div>Header</div>
            //<React.Fragment>Header</React.Fragment>
            <>
                {/* navbar First start */}
                <header>
                    <h1>Todo Input</h1>
                </header>
                <div class ="header">
                    <div class="input-icons">

                        <div class="column">
                            <i class="fa-solid fa-clipboard-list icon_size"></i>
                            <input class="input-field" type="text" id="myInput" placeholder="New Todo"/>
                        </div>
                        <div class="column">
                            <button class="button button2">Add New Task</button>
                        </div>

                    </div>

                </div>
            </>)
    }
}
// export default Header;
// i18n Wrapper
// export default withTranslation()(Header)
export default withTranslation()(Header);



