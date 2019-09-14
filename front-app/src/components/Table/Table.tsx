import React from 'react';
// import { Button, Colors, AccentButton, Modal } from 'storybook-directual';

// import { withRouter } from "react-router";
// import PageHeader from '../components/PageHeader/PageHeader';
// import HomePageContent from '../components/HomePageContent/HomePageContent';


const Table = ({ columns = [], dataSource = [] }: { columns: any, dataSource: any }) => {
  return (
    <table style={{
      borderSpacing: '0 5px',
    }}>
      <thead style={{
        color:'#8E8E8E',
        fontSize: '18px',
      }}>
        <tr>
          {columns.map((col:any) => (
          <td
            id={col.key}
            style={{
              width: col.width,
            }}
            // className="Subheader_14-24_Black"
          >
            {col.title}
          </td>))}
        </tr>
      </thead>
    
      <tbody>
        {dataSource.map((row: any) => {
          return (
            <tr
              style={{
                fontSize: '16px',
              }}
            >
             {columns.map((col: any) => (
              <td
                id={col.key}
                style={{
                  width: col.width,
                }}
                // className="Subheader_14-24_Black"
              >
                {row[col.key]}
              </td>))}
            </tr>
          )
        })}
      </tbody>
    </table>
  );
};

export default Table;