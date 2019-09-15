import React, { Component, SyntheticEvent } from 'react';
import { Modal, CardImaged, Button, AccentButton, Tag, IconButton, Input, Notification } from 'storybook-directual';

import get from 'lodash/get';

import './index.scss';
import { getUserImages, collaborate } from '../../utils/http';
// import Editor from '../Editor/Editor';
import {Editor, EditorState } from 'draft-js';
// import { throwStatement } from '@babel/types';


type Props = {
  recommended: any;
  enrollCb: any;
};

const styles = {
  editor: {
    border: '1px solid gray',
    minHeight: '6em'
  }
};

class CardsList extends Component<Props> {
  editor: any;

  state = {
    user: {
      id: '743f885c-d740-11e9-8a34-2a2ae2dbcce4',
    },
    message: [],
    images: [],
    showModal: false,
    activeRecomendation: null,
    editorState: EditorState.createEmpty(),
    textValue: '',
  }

  componentDidMount() {
    // getUserImages().then((response) => {
    //   const images = response.results.map((user: any) => user.picture.large);

    //   this.setState({
    //     images,
    //   });
    // });

    this.focusEditor();
  }

  onTextChange = (value: any) => {
    this.setState({
      textValue: value,
    })
  }

  collaborate = () => {
    const userTo = get(this.state, 'activeRecomendation.userId', null);

    if (!this.state.textValue) return;
    collaborate(this.state.user.id, userTo, this.state.textValue).then((res) => {

      this.setState({
        showModal: false,
      });

      this.props.enrollCb('2');
    });
  }

  onChange = (editorState:any) => {
    console.log('EDITOR STATE', editorState);
    this.setState({editorState});
  }

  setEditor = (editor:any) => {
    this.editor = editor;
  };

  focusEditor = () => {
    if (this.editor) {
      this.editor.focus();
    }
  };

  showModal = (recomendation: any) => (): void => {
    this.setState({
      showModal: true,
      activeRecomendation: recomendation,
    });
  };

  hideModal = (): void => {
    this.setState({
      showModal: false,
      activeRecomendation: null,
    });
  };

  static defaultProps: Props;

  removeRecomendation = (recId:string) => {
    // event.stopPropagation();

    console.log('recId', recId)
  }

  renderMenu = (recId: string) => {
    return (
      <div className="card-controls" onClick={e => {
        e.stopPropagation();
        this.removeRecomendation(recId)
      }}>
        <IconButton onClick={() => {}}
        icon="delete"/>
        {/* <Button>Не интересно</Button> */}
        {/* <AccentButton>Интересно</AccentButton> */}
      </div>
    )
  }

  render() {
    return (
      <div className="recommended-list-wrapper">
        <div className="recommended-list">
          {this.props.recommended.map((rec: any, index: number) => (
            <div onClick={this.showModal(rec)}>
              <CardImaged
                image={rec.image}
                // image={{
                //   url: this.state.images[index],
                // }}
                header={rec.header}
                headerComment={(
                <div>
                  {rec.headerComment}
                  <div className="card-tags">
                    {rec.tags && rec.tags.map((tag:any) => (
                      <Tag colorGroup={tag.type === 'advert' ? '1-5' : '2-2'}>{tag.text}</Tag>
                    ))}
                  </div>
                </div>)}
                menu={this.renderMenu(rec.id)}
              />
            </div>
          ))}
        </div>

        <Modal
          show={this.state.showModal}
          header={get(this.state,'activeRecomendation.header', '')}
          buttons={[
            <AccentButton className="yellow-btn" key="1111" onClick={this.collaborate}>
              Сотрудничать
            </AccentButton>,
            <Button key="2222" onClick={this.hideModal}>Закрыть</Button>,
          ]}
          // onClick={() => {}}
          columnsNumber={1}
          column1={(
            <div className="modal-content">
              <div className="Header_32-40_Black">
                {get(this.state,'activeRecomendation.headerComment', '')}
              </div>
              <div className="card-tags">
                {get(this.state,'activeRecomendation.tags', []).map((tag:any) => (
                  <Tag colorGroup={tag.type === 'advert' ? '1-5' : '2-2'}>{tag.text}</Tag>
                ))}
              </div>

              <div
                className="Mono_14-24_Black"
                style={{
                  marginBottom: 30,
                  marginTop: 30,
                }}
              >
                Сопроводительное письмо (напишите немного о себе и о своем деле)
              </div>
              <Input.Textarea
                value={this.state.textValue}
                onChange={this.onTextChange}
              />
              {/* <div
                style={styles.editor}
                onClick={this.focusEditor}
              >
                <Editor
                  ref={this.setEditor}
                  editorState={this.state.editorState}
                  onChange={this.onChange}
                />
              </div> */}
              {/* <Editor
                setRef={}
                onChange={() => {}}
              /> */}
              {/* <p
                style={{
                  marginTop: 25,
                }}
              >
              {get(this.state,'activeRecomendation.fullDescription', '')}</p> */}
            </div>
          )}
        />
      </div>
    )
  }
}

export default CardsList;
