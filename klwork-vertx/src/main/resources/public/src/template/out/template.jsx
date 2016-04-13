React.createClass({
  render: function() {
    return (

      <div className="wrapper wrapper-content">
        <div className="row">
          <div className="col-sm-3">
            <div className="ibox float-e-margins">
              <div className="ibox-content mailbox-content">
                <div className="file-manager">
                  <a className="btn btn-block btn-primary compose-mail" href="mail_compose.html">写信</a>
                  <div className="space-25" />
                  <h5>文件夹</h5>
                  <ul className="folder-list m-b-md" style={{padding: 0}}>
                    <li>
                      <a href="mailbox.html"> <i className="fa fa-inbox " /> 收件箱 <span className="label label-warning pull-right">16</span>
                      </a>
                    </li>
                    <li>
                      <a href="mailbox.html"> <i className="fa fa-envelope-o" /> 发信</a>
                    </li>
                    <li>
                      <a href="mailbox.html"> <i className="fa fa-certificate" /> 重要</a>
                    </li>
                    <li>
                      <a href="mailbox.html"> <i className="fa fa-file-text-o" /> 草稿 <span className="label label-danger pull-right">2</span>
                      </a>
                    </li>
                    <li>
                      <a href="mailbox.html"> <i className="fa fa-trash-o" /> 垃圾箱</a>
                    </li>
                  </ul>
                  <h5>分类</h5>
                  <ul className="category-list" style={{padding: 0}}>
                    <li>
                      <a href="mail_compose.html#"> <i className="fa fa-circle text-navy" /> 工作</a>
                    </li>
                    <li>
                      <a href="mail_compose.html#"> <i className="fa fa-circle text-danger" /> 文档</a>
                    </li>
                    <li>
                      <a href="mail_compose.html#"> <i className="fa fa-circle text-primary" /> 社交</a>
                    </li>
                    <li>
                      <a href="mail_compose.html#"> <i className="fa fa-circle text-info" /> 广告</a>
                    </li>
                    <li>
                      <a href="mail_compose.html#"> <i className="fa fa-circle text-warning" /> 客户端</a>
                    </li>
                  </ul>
                  <h5 className="tag-title">标签</h5>
                  <ul className="tag-list" style={{padding: 0}}>
                    <li><a href="mail_compose.html"><i className="fa fa-tag" /> 朋友</a>
                    </li>
                    <li><a href="mail_compose.html"><i className="fa fa-tag" /> 工作</a>
                    </li>
                    <li><a href="mail_compose.html"><i className="fa fa-tag" /> 家庭</a>
                    </li>
                    <li><a href="mail_compose.html"><i className="fa fa-tag" /> 孩子</a>
                    </li>
                    <li><a href="mail_compose.html"><i className="fa fa-tag" /> 假期</a>
                    </li>
                    <li><a href="mail_compose.html"><i className="fa fa-tag" /> 音乐</a>
                    </li>
                    <li><a href="mail_compose.html"><i className="fa fa-tag" /> 照片</a>
                    </li>
                    <li><a href="mail_compose.html"><i className="fa fa-tag" /> 电影</a>
                    </li>
                  </ul>
                  <div className="clearfix" />
                </div>
              </div>
            </div>
          </div>
          <div className="col-sm-9 animated fadeInRight">
            <div className="mail-box-header">
              <form method="get" action="index.html" className="pull-right mail-search">
                <div className="input-group">
                  <input type="text" className="form-control input-sm" name="search" placeholder="搜索邮件标题，正文等" />
                  <div className="input-group-btn">
                    <button type="submit" className="btn btn-sm btn-primary">
                      搜索
                    </button>
                  </div>
                </div>
              </form>
              <h2>
                收件箱 (16)
              </h2>
              <div className="mail-tools tooltip-demo m-t-md">
                <div className="btn-group pull-right">
                  <button className="btn btn-white btn-sm"><i className="fa fa-arrow-left" />
                  </button>
                  <button className="btn btn-white btn-sm"><i className="fa fa-arrow-right" />
                  </button>
                </div>
                <button className="btn btn-white btn-sm" data-toggle="tooltip" data-placement="left" title="刷新邮件列表"><i className="fa fa-refresh" /> 刷新</button>
                <button className="btn btn-white btn-sm" data-toggle="tooltip" data-placement="top" title="标为已读"><i className="fa fa-eye" />
                </button>
                <button className="btn btn-white btn-sm" data-toggle="tooltip" data-placement="top" title="标为重要"><i className="fa fa-exclamation" />
                </button>
                <button className="btn btn-white btn-sm" data-toggle="tooltip" data-placement="top" title="标为垃圾邮件"><i className="fa fa-trash-o" />
                </button>
              </div>
            </div>
            <div className="mail-box">
              <table className="table table-hover table-mail">
                <tbody>
                  <tr className="unread">
                    <td className="check-mail">
                      <input type="checkbox" className="i-checks" />
                    </td>
                    <td className="mail-ontact"><a href="mail_detail.html">支付宝</a>
                    </td>
                    <td className="mail-subject"><a href="mail_detail.html">支付宝提醒</a>
                    </td>
                    <td className><i className="fa fa-paperclip" />
                    </td>
                    <td className="text-right mail-date">昨天 10:20</td>
                  </tr>
                  <tr className="unread">
                    <td className="check-mail">
                      <input type="checkbox" className="i-checks" defaultChecked />
                    </td>
                    <td className="mail-ontact"><a href="mail_detail.html">Amaze UI</a>
                    </td>
                    <td className="mail-subject"><a href="mail_detail.html">Amaze UI Beta2 发布</a>
                    </td>
                    <td className />
                    <td className="text-right mail-date">上午10:57</td>
                  </tr>
                  <tr className="read">
                    <td className="check-mail">
                      <input type="checkbox" className="i-checks" />
                    </td>
                    <td className="mail-ontact"><a href="mail_detail.html">WordPress</a> <span className="label label-warning pull-right">验证邮件</span>
                    </td>
                    <td className="mail-subject"><a href="mail_detail.html">wp-user-frontend-pro v2.1.9</a>
                    </td>
                    <td className />
                    <td className="text-right mail-date">上午9:21</td>
                  </tr>
                  <tr className="read">
                    <td className="check-mail">
                      <input type="checkbox" className="i-checks" />
                    </td>
                    <td className="mail-ontact"><a href="mail_detail.html">淘宝网</a>
                    </td>
                    <td className="mail-subject"><a href="mail_detail.html">史上最全！淘宝双11红包疯抢攻略！</a>
                    </td>
                    <td className />
                    <td className="text-right mail-date">中午12:24</td>
                  </tr>
                  <tr className="read">
                    <td className="check-mail">
                      <input type="checkbox" className="i-checks" />
                    </td>
                    <td className="mail-ontact"><a href="mail_detail.html">淘宝网</a> <span className="label label-danger pull-right">AD</span>
                    </td>
                    <td className="mail-subject"><a href="mail_detail.html">亲，双11来啦！帮你挑货，还送你4999元红包！仅此一次！</a>
                    </td>
                    <td className><i className="fa fa-paperclip" />
                    </td>
                    <td className="text-right mail-date">上午6:48</td>
                  </tr>
                  <tr className="read">
                    <td className="check-mail">
                      <input type="checkbox" className="i-checks" />
                    </td>
                    <td className="mail-ontact"><a href="mail_detail.html">支付宝</a>
                    </td>
                    <td className="mail-subject"><a href="mail_detail.html">支付宝提醒</a>
                    </td>
                    <td className><i className="fa fa-paperclip" />
                    </td>
                    <td className="text-right mail-date">昨天 10:20</td>
                  </tr>
                  <tr className="read">
                    <td className="check-mail">
                      <input type="checkbox" className="i-checks" />
                    </td>
                    <td className="mail-ontact"><a href="mail_detail.html">Amaze UI</a>
                    </td>
                    <td className="mail-subject"><a href="mail_detail.html">Amaze UI Beta2 发布</a>
                    </td>
                    <td className />
                    <td className="text-right mail-date">上午10:57</td>
                  </tr>
                  <tr className="read">
                    <td className="check-mail">
                      <input type="checkbox" className="i-checks" />
                    </td>
                    <td className="mail-ontact"><a href="mail_detail.html">WordPress</a> <span className="label label-warning pull-right">验证邮件</span>
                    </td>
                    <td className="mail-subject"><a href="mail_detail.html">wp-user-frontend-pro v2.1.9</a>
                    </td>
                    <td className />
                    <td className="text-right mail-date">上午9:21</td>
                  </tr>
                  <tr className="read">
                    <td className="check-mail">
                      <input type="checkbox" className="i-checks" />
                    </td>
                    <td className="mail-ontact"><a href="mail_detail.html">淘宝网</a>
                    </td>
                    <td className="mail-subject"><a href="mail_detail.html">史上最全！淘宝双11红包疯抢攻略！</a>
                    </td>
                    <td className />
                    <td className="text-right mail-date">中午12:24</td>
                  </tr>
                  <tr className="read">
                    <td className="check-mail">
                      <input type="checkbox" className="i-checks" />
                    </td>
                    <td className="mail-ontact"><a href="mail_detail.html">淘宝网</a> <span className="label label-danger pull-right">AD</span>
                    </td>
                    <td className="mail-subject"><a href="mail_detail.html">亲，双11来啦！帮你挑货，还送你4999元红包！仅此一次！</a>
                    </td>
                    <td className><i className="fa fa-paperclip" />
                    </td>
                    <td className="text-right mail-date">上午6:48</td>
                  </tr>
                  <tr className="read">
                    <td className="check-mail">
                      <input type="checkbox" className="i-checks" />
                    </td>
                    <td className="mail-ontact"><a href="mail_detail.html">支付宝</a>
                    </td>
                    <td className="mail-subject"><a href="mail_detail.html">支付宝提醒</a>
                    </td>
                    <td className><i className="fa fa-paperclip" />
                    </td>
                    <td className="text-right mail-date">昨天 10:20</td>
                  </tr>
                  <tr className="read">
                    <td className="check-mail">
                      <input type="checkbox" className="i-checks" />
                    </td>
                    <td className="mail-ontact"><a href="mail_detail.html">Amaze UI</a>
                    </td>
                    <td className="mail-subject"><a href="mail_detail.html">Amaze UI Beta2 发布</a>
                    </td>
                    <td className />
                    <td className="text-right mail-date">上午10:57</td>
                  </tr>
                  <tr className="read">
                    <td className="check-mail">
                      <input type="checkbox" className="i-checks" />
                    </td>
                    <td className="mail-ontact"><a href="mail_detail.html">WordPress</a> <span className="label label-warning pull-right">验证邮件</span>
                    </td>
                    <td className="mail-subject"><a href="mail_detail.html">wp-user-frontend-pro v2.1.9</a>
                    </td>
                    <td className />
                    <td className="text-right mail-date">上午9:21</td>
                  </tr>
                  <tr className="read">
                    <td className="check-mail">
                      <input type="checkbox" className="i-checks" />
                    </td>
                    <td className="mail-ontact"><a href="mail_detail.html">淘宝网</a>
                    </td>
                    <td className="mail-subject"><a href="mail_detail.html">史上最全！淘宝双11红包疯抢攻略！</a>
                    </td>
                    <td className />
                    <td className="text-right mail-date">中午12:24</td>
                  </tr>
                  <tr className="read">
                    <td className="check-mail">
                      <input type="checkbox" className="i-checks" />
                    </td>
                    <td className="mail-ontact"><a href="mail_detail.html">淘宝网</a> <span className="label label-danger pull-right">AD</span>
                    </td>
                    <td className="mail-subject"><a href="mail_detail.html">亲，双11来啦！帮你挑货，还送你4999元红包！仅此一次！</a>
                    </td>
                    <td className><i className="fa fa-paperclip" />
                    </td>
                    <td className="text-right mail-date">上午6:48</td>
                  </tr>
                </tbody>
              </table>
            </div>
          </div>
        </div>
      </div>
      {/* 全局js */}
      {/* 自定义js */}
      {/* iCheck */}
      {/*统计代码，可删除*/}
    );
  }
});