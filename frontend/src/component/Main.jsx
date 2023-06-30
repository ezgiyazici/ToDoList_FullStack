// rcc
import React, { Component } from 'react'

// css
import './style.css'

// i18n
import { withTranslation } from 'react-i18next';

// CLASS Component
class Main extends Component {

    // Componentteki yeni isim
    static displayName = "Blog_Main";

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
            // <div>Main</div>
            //<React.Fragment>Main</React.Fragment>
                <>
                    {/* main start */}
                    <main id="main_id">
                    </main>
                    {/* main end */}
                </>
        ) //end return
    } // end render
}//end clas

// export default Main
// i18n Wrapper
export default withTranslation()(Main)   

