import React from 'react';
import {Editor, EditorState } from 'draft-js';

class MyEditor extends React.Component<any, any> {
  editor: any;

  constructor(props:any) {
    super(props);
    this.editor = null;
    this.state = {
      editorState: EditorState.createEmpty()
    };
  }

  onChange = (editorState:any) => this.setState({editorState});
  setEditor = (editor:any) => {
    this.editor = editor;
  };

  focusEditor = () => {
    if (this.editor) {
      this.editor.focus();
    }
  };

  componentDidMount() {
    this.focusEditor();
  }

  render() {
    return (
      <div style={styles.editor} onClick={this.focusEditor}>
        <Editor
          ref={this.setEditor}
          editorState={this.state.editorState}
          onChange={this.onChange}
        />
      </div>
    );
  }
}

const styles = {
  editor: {
    border: '1px solid gray',
    minHeight: '6em'
  }
};

export default MyEditor;