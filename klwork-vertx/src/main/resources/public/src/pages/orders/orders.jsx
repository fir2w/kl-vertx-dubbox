import React from 'react';
import {Modal,Input} from 'react-bootstrap';

import ProductQueryForm from './productQueryForm';

import MyAddProductContent from './myAddProductContent';
import { Table } from 'antd';
import OrderStore from './orderStore';


function onRowSelect(row, isSelected) {
  console.log(row);
  console.log("selected: " + isSelected)
}

function onSelectAll(isSelected, currentDisplayAndSelectedData) {
  console.log("is select all: " + isSelected);
  console.log("Current select and display data: ");
  console.log(currentDisplayAndSelectedData);
}

function onAfterSaveCell(row, cellName, cellValue) {
  console.log("Save cell '" + cellName + "' with value '" + cellValue + "'");
  console.log("Thw whole row :");
  console.log(row);
}

function onAfterTableComplete() {
  console.log('Table render complete.');
}

function onAfterDeleteRow(rowKeys) {
  console.log("onAfterDeleteRow");
  console.log(rowKeys);
}

function onAfterInsertRow(row) {
  console.log("onAfterInsertRow");
  console.log(row);
}


function handleDropRowBtnClick() {

}

var selectRowProp = {
  mode: "checkbox",
  clickToSelect: true,
  // hideSelectColumn: true, //you can hide select column, if you enable clickToSelect
  selected: [], //default selection on table
  bgColor: "rgb(238, 193, 213)",
  onSelect: onRowSelect,
  onSelectAll: onSelectAll
};

var cellEditProp = {
  mode: "click",
  blurToSave: true,
  afterSaveCell: onAfterSaveCell
};

var options = {
  // page: 3,
  // sizePerPage: 5,
  // sizePerPageList: [5,10,15,20],
  // paginationSize: 6,
  sortName: "name",  //default sort column name
  sortOrder: "desc",  //default sort order
  afterTableComplete: onAfterTableComplete, // A hook for after table render complete.
  afterDeleteRow: onAfterDeleteRow,  // A hook for after droping rows.
  afterInsertRow: onAfterInsertRow   // A hook for after insert rows
};


var columns = [{
  title: '姓名',
  dataIndex: 'name',
}, {
  title: '年龄',
  dataIndex: 'age',
}, {
  title: '住址',
  dataIndex: 'address',
}];

var data = [];
for (let i = 0; i < 46; i++) {
  data.push({
    key: i,
    name: '李大嘴' + i,
    age: 32,
    address: '西湖区湖底公园' + i + '号'
  });
}

function priceFormatter(cell, row) {
  return '<i class="glyphicon glyphicon-usd"></i> ' + cell;
}


export default React.createClass({
  getInitialState: function () {
    return {
      products: [],
      showModal: false,
      selectProduct: {name: 'wangwei'}
    };
  },
  onMyAddRowBegin: function () {
    this.setState(
      {
        showModal: true,
        selectProduct: {name: 'wangwei22'}
      }
    );
  },

  close: function () {
    this.setState({showModal: false});
  },
  handleChange: function () {
  },
  _queryProducts: function () {
    var that = this;
    OrderStore.queryAll(function(data){
      alert(data);
      that.setState({
        products: data
      });
    });
  },
  componentDidMount: function () {
    //查询
  },

  render: function () {
    console.log('init reder');
    var rowSelection = {
    };
    return (

      <div className="box box-info">
        <div className="box-header with-border">
          <h3 className="box-title">订单查询</h3>
        </div>
        <div className="box-body">
          <ProductQueryForm queryProducts={this._queryProducts}></ProductQueryForm>


          <div id="table_all">
            <div className="btn-group btn-group-xs" role="group"
                 aria-label="...">
              <button type="button" onClick={this.onMyAddRowBegin}
                      className="btn btn-info" data-toggle="modal"
                      data-target='.addProducet'>
                <i className="glyphicon glyphicon-plus"></i> New
              </button>
              <button type="button" className="btn btn-warning"
                      data-toggle="tooltip" data-placement="right"
                      title="Drop selected row"
                      onClick={this.handleDropRowBtnClick}>
                <i className="glyphicon glyphicon-trash"></i> Delete
              </button>
            </div>


            <div>
              <Table rowSelection={rowSelection} columns={columns} dataSource={data} />
            </div>

          </div>
        </div>
      </div>
    )
  }
});