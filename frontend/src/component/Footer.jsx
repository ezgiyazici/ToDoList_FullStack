// rcc
import React, { Component } from 'react'
import { withTranslation } from 'react-i18next';

// CLASS Component
class Footer extends Component {

    // Componentteki yeni isim
    static displayName="Blog_Footer";

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
            // <div>Footer</div>
            //<React.Fragment>Footer</React.Fragment>
            <>
            {/* footer start */}
            <footer id="footer_id">
            <h1>Footer</h1>
            </footer>

            {/* footer end */}


          </>
          
        ) //end return
    } // end render
}//end clas

// export default Footer
// i18n Wrapper
export default withTranslation()(Footer)