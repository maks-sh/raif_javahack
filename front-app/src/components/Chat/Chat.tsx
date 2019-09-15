import React, { Component, SyntheticEvent } from 'react';
import { Icon, Input, IconButton } from 'storybook-directual';

import moment from 'moment';

import get from 'lodash/get';

import './index.scss';
import { getChat, sendMessage } from '../../utils/http';

type Props = {
  chats: any;
};

class Chat extends Component<Props> {
  state = {
    activeChat: null,
    message: '',
  };

  activateChat = (chat: any) => () => {
    getChat('743f885c-d740-11e9-8a34-2a2ae2dbcce4', chat.id).then(res => {
      this.setState({
        activeChat: {
          ...chat,
          messages: [
            chat.messages[0],
            ...res.sort((m1:any, m2:any) => moment(m1.time).unix() - moment(m2.time).unix()),
          ],
        },
        message: '',
      })
    });
  }

  setMessage = (value: any) => {
    this.setState({
      message: value,
    })
  }

  submitMessage = () => {
    if (!this.state.message) return;
    const activeChatId = get(this.state, 'activeChat.id', '');
    if (!activeChatId) return;

    sendMessage('743f885c-d740-11e9-8a34-2a2ae2dbcce4', activeChatId, this.state.message).then(res => {
      this.activateChat(this.state.activeChat)();
    });
  }

  render() {
    const activeChatMessages = get(this.state, 'activeChat.messages', []);
    const activeChatId = get(this.state, 'activeChat.id', []);

    return (
      <div className="chats">
        <div className="availible-chats">
          {this.props.chats.map((chat: any) => {
            const icon = get(chat,'user.image.url', '');
            const title = get(chat,'user.title', '');
            const desc = get(chat,'user.desc', '');
            const lastMsg = get(chat,'messages[0]', {
              text: '',
              timestamp: 0,
            });

            return (<div
              className={[
                "chat-item",
                chat.id === activeChatId
                ? 'chat-item-active'
                : ''
              ].join(' ')}
              onClick={this.activateChat(chat)}
            >
              <div className="chat-icon"></div>
              <div className="chat-title Subheader_14-24_Black">{title}</div>
              <div className="chat-desc Subheader_14">{desc}</div>
              <div className="chat-last-msg Comment_12-16">
                {lastMsg.source === 'MY' && 'Вы: '}
                {lastMsg.text}
              </div>
            </div>)
          })}
        </div>
        <div className="active-chat">
          {
            this.state.activeChat
            ? <div className="chat-window">
              <div className="messages">
                {
                  !activeChatMessages.length &&
                  <div className="Mono_14-24_Black" style={{ padding: '50px 0' }}>В чате пока нет сообщений</div>
                }
                {
                  activeChatMessages.map((msg: any) => {
                    return (<div className={[ 'message', msg.source === 'MY' && 'my-message'].join(' ')}>
                      {msg.text}
                    </div>)
                  }) 
                }


                {/* {JSON.stringify(this.state.activeChat)} */}
              </div>
              <div className="controls">
                <Input.Textarea
                  className="text-input"
                  onChange={this.setMessage}
                  value={this.state.message}
                />
                <IconButton icon="play" onClick={this.submitMessage} />
              </div>
            </div>
            : <div className="no-chat">
              <Icon
                style={{
                  width: 150,
                  height: 150,
                }}
                type="bubble"
              />
              <div className="Mono_14-24_Black">Выберите чат</div>
            </div>
          }
        </div>
      </div>
    )
  }
}

export default Chat;
