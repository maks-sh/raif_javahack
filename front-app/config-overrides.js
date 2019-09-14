const { override, fixBabelImports, addLessLoader } = require('customize-cra')

module.exports = override(
  fixBabelImports('import', {
    libraryName: 'antd',
    libraryDirectory: 'es',
    style: true,
  }),
  // addLessLoader({
  //   javascriptEnabled: true,
  //   modifyVars: {
  //     // '@primary-color': '#8c2a94', // primary color for all components
  //     '@primary-color': '#762BFF', // primary color for all components
  //     '@link-color': '#1890ff', // link color
  //     '@success-color': '#52c41a', // success state color
  //     '@warning-color': '#faad14', // warning state color
  //     '@error-color': '#fc0243', // error state color
  //     '@font-size-base': '14px', // major text font size
  //     '@heading-color': 'rgba(255, 255, 255, 0.85)', // heading text color
  //     '@text-color': 'fade(#fff, 65%)',
  //     '@text-color-secondary': 'fade(#fff, 45%)',
  //     // '@text-color': '#fff', // major text color
  //     // '@text-color-secondary': 'rgba(0, 0, 0, .45)', // secondary text color
  //     '@disabled-color': 'rgba(0, 0, 0, .25)', // disable state color
  //     // '@disabled-color': 'rgba(255, 255, 255, .25)', // disable state color
  //     '@border-radius-base': '0px', // major border radius
  //     '@border-color-base': '#d9d9d9', // major border color
  //     '@box-shadow-base': '0 2px 8px rgba(0, 0, 0, 0.15)', // major shadow for layers
  //     '@component-background': 'rgba(255,255,255,0)',
  //     '@table-selected-row-bg': 'rgba(118,43,255,0.4)',
  //     '@item-active-bg': 'rgba(118,43,255,0.4)',
  //     '@item-hover-bg': 'rgba(118,43,255,0.4)',
  //     '@table-expanded-row-bg': 'rgba(118,43,255,0.4)',
  //     '@table-body-sort-bg': 'rgba(118,43,255,0.4)',
  //     '@table-row-hover-bg': 'rgba(118,43,255,0.4)',
  //   },
  // }),
);