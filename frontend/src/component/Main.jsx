
// rcc
import React, { Component } from 'react'

// i18n
import { withTranslation } from 'react-i18next';

// Blog Api Services
import TodoApiServices from '../services/TodoApiServices.js';
import './style.css'

// CLASS Component
class Main extends Component {

    // Componentteki yeni isim
    static displayName = "Main";

    // CONSTRUCTOR
    constructor(props) {
        super(props);

        //state
        this.state = {
            blogList: [],
        }

        // bind
        this.create = this.create.bind(this);
        this.update = this.update.bind(this);
        this.delete = this.delete.bind(this);
    }

    // CDM (Promise)
    componentDidMount() {
        TodoApiServices.blogServiceList().then(
            (response) => {
                this.setState({
                    blogList: response.data
                }); // end setState 
            }
        ).catch((error) => {
            console.error("List Failed: " + error)
        });
    }

    // FUNCTION
    // PHP CREATE
    create() {
        this.props.history.push("/blog/create");
    }

    // PHP UPDATE(id)
    update(id) {
        this.props.history.push("/blog/update/" + id);
    }


    // PHP DELETE(id)
    delete(id) {
        TodoApiServices.blogServiceDeleteById(id).then(
            (response) => {
                this.setState({
                    blogList: this.state.blogList.filter(
                        blogList => blogList.id !== id
                    )//end filter
                })// end setState
            }// end response
        ).catch(error => {
            console.error("Blog Delete Failed: " + error)
        })
    }

    //RENDER
    render() {
  
        // PROPS
        const { t } = this.props;

        //RETURN
        return (
            <React.Fragment>
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

                    <h2 class="text-center"> {this.props.t('Todo List')}</h2>
                {/* Create Button Blog */}
                <div>
                <table class="table table-hover table-striped">
                    <tbody>
                        {
                            this.state.blogList.map((blog) =>
                                <tr key={blog.id}>
                                    <td>{blog.header}</td>
                                    <input
                                        type="checkbox"
                                        name="myTextEditBox"
                                        defaultValue="checked"
                                        style={{ marginTop: 15 }}
                                        />
                                    {/* UPDATE */}
                                    <td>
                                        <i
                                            class="fa-solid fa-pen-to-square text-primary"
                                            style={{ cursor: "pointer" }}
                                            onClick={() => this.update(blog.id)} ></i>
                                    </td>

                                    {/* DELETE */}
                                    <td>
                                        <i
                                            class="fa-solid fa-trash text-danger"
                                            style={{ cursor: "pointer" }}
                                            onClick={() => {
                                                if (window.confirm(blog.id + " ID Blog silmek istiyor musunuz ?"))
                                                    this.delete(blog.id)
                                                else
                                                    window.alert("Silinmedi !!!");
                                            } //end function
                                          }></i>
                                    </td>
                                </tr>) // end map
                        }
                    </tbody>
                </table>
                </div>
                <div class="buttons">

<div class="action_btn">

<button name="submit" class="action_btn submit" type="submit" value="Save" onclick="myFunction()">Save</button>
<button name="submit" class="action_btn cancel" type="submit" value="Cancel" onclick="myFunction2()">Cancel</button>

<p id="saved"></p>

</div>

</div>
                </div>
            

            </React.Fragment>
        ) //end return
    } // end render
}//end clas

// export default Footer
// i18n Wrapper
export default withTranslation()(Main)