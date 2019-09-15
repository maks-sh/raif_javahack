import React from 'react';

const Table = ({ columns = [], dataSource = [] }: { columns: any, dataSource: any }) => {
  return (
    <table style={{
      borderSpacing: '10px',
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
                {
                  col.render
                  ? col.render(row)
                  : row[col.key]}
              </td>))}
            </tr>
          )
        })}
      </tbody>
    </table>
  );
};

export default Table;