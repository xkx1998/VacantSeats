<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
	pageContext.setAttribute("App_Path", request.getContextPath());
%>
<html>
<head>
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
	<title>图书馆人流量检测系统</title>
	<meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0, shrink-to-fit=no' name='viewport' />
	<link rel="stylesheet" href="${App_Path}/static/assets/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i">
	<link rel="stylesheet" href="${App_Path}/static/assets/css/ready.css">
	<link rel="stylesheet" href="${App_Path}/static/assets/css/demo.css">
    <script type="text/javascript" src="${App_Path}/static/js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript">
        //页面加载完成后，直接去发送一个ajax请求,要到图书馆地点数据
        $(document).ready(function () {
            getPlaces();

            getInfoByplaceid(1);

            /**
			 * 根据地点Id获取人流量信息
			 */
            function getInfoByplaceid(placeid) {
                $.ajax({
                    url: "${App_Path}/humanflow/getByPlaceId",
                    data: "placeid=" + placeid
                    , type: "GET"
                    , success: function (result) {
                        console.log(result);
                        //1.解析并显示人流量信息
                        build_flow_info(result)

                    }
                });
			}

			//构建人流量信息

			function build_flow_info(result) {
                var capacity = result.extend.capacity;
                var curNum = result.extend.curNum;
                var maxNum = result.extend.maxNum;
                var minNum = result.extend.minNum;
                var attendance = result.extend.attendance;
                var clevel = result.extend.clevel;
                var maxNumPro = result.extend.maxNumPro;
                var minNumPro = result.extend.minNumPro;
                var avgNumPro = result.extend.avgNumPro;
                $("#curNum_div").empty();
                var p_1 = $("<p></p>").addClass("card-category").append("当前人流量");
				var h4_1 = $("<h4></h4>").addClass("card-title").append(curNum);
				$("#curNum_div").append(p_1).append(h4_1);

                $("#capacity_div").empty();
                var p_2 = $("<p></p>").addClass("card-category").append("楼层容量");
                var h4_2 = $("<h4></h4>").addClass("card-title").append(capacity);
                $("#capacity_div").append(p_2).append(h4_2);

                $("#maxNum_div").empty();
                var p_3 = $("<p></p>").addClass("card-category").append("今日最多人数");
                var h4_3 = $("<h4></h4>").addClass("card-title").append(maxNum);
                $("#maxNum_div").append(p_3).append(h4_3);

                $("#minNum_div").empty();
                var p_4 = $("<p></p>").addClass("card-category").append("今日最少人数");
                var h4_4 = $("<h4></h4>").addClass("card-title").append(minNum);
                $("#minNum_div").append(p_4).append(h4_4);

                $("#attendance_div").empty();
                var p_5 = $("<p></p>").addClass("card-category").append("上座率");
                var h4_5 = $("<h4></h4>").addClass("card-title").append(attendance+"%");
                $("#attendance_div").append(p_5).append(h4_5);

                $("#clevel_div").empty();
                var p_6 = $("<p></p>").addClass("card-category").append("拥挤程度");
                var h4_6 = $("<h4></h4>").addClass("card-title").append(clevel);
                $("#clevel_div").append(p_6).append(h4_6);

                //当前上座率条形
                $("#attendance_cur_div").empty();
                var span_1 = $("<span></span>").addClass("text-muted").append("当前人数占比(%)");
                var span_2 = $("<span></span>").addClass("text-muted").append(attendance+"%");
                $("#attendance_cur_div").append(span_1).append(span_2);


                $("#attendance_cur_div_show").empty();
                var div_1 = $("<div></div>").addClass("progress-bar bg-success").attr("role","progressbar")
                    .css({"width":attendance+"%"},{"aria-valuenow":"78"},{"aria-valuemin":"0"},
                        {"aria-valuemax":"100"},{"data-toggle":"tooltip"},{"data-placement":"top"},
                        {"title":attendance+"%"});
                $("#attendance_cur_div_show").append(div_1);

                //最多人数条状图形
                $("#maxNumPro_div").empty();
                var span_3 = $("<span></span>").addClass("text-muted").append("今日最多人数占比(%)");
                var span_4 = $("<span></span>").addClass("text-muted").append(maxNumPro+"%");
                $("#maxNumPro_div").append(span_3).append(span_4);

                $("#maxNumPro_div_show").empty();
                var div_2 = $("<div></div>").addClass("progress-bar bg-info").attr("role","progressbar")
                    .css({"width":maxNumPro+"%"},{"aria-valuenow":"60"},{"aria-valuemin":"0"},
                        {"aria-valuemax":"100"},{"data-toggle":"tooltip"},{"data-placement":"top"},
                        {"title":maxNumPro+"%"});
                $("#maxNumPro_div_show").append(div_2);

                //最少人数条形图形
                $("#minNumPro_div").empty();
                var span_5 = $("<span></span>").addClass("text-muted").append("今日最少人数占比(%)");
                var span_6 = $("<span></span>").addClass("text-muted").append(minNumPro+"%");
                $("#minNumPro_div").append(span_5).append(span_6);

                $("#minNumPro_div_show").empty();
                var div_3 = $("<div></div>").addClass("progress-bar bg-primary").attr("role","progressbar")
                    .css({"width":minNumPro+"%"},{"aria-valuenow":"70"},{"aria-valuemin":"0"},
                        {"aria-valuemax":"100"},{"data-toggle":"tooltip"},{"data-placement":"top"},
                        {"title":minNumPro+"%"});
                $("#minNumPro_div_show").append(div_3);

                //平均人数条形图形
                $("#avgNumPro_div").empty();
                var span_7 = $("<span></span>").addClass("text-muted").append("平均人数占比(%)");
                var span_8 = $("<span></span>").addClass("text-muted").append(avgNumPro+"%");
                $("#avgNumPro_div").append(span_7).append(span_8);

                $("#avgNumPro_div_show").empty();
                var div_4 = $("<div></div>").addClass("progress-bar bg-primary").attr("role","progressbar")
                    .css({"width":avgNumPro+"%"},{"aria-valuenow":"70"},{"aria-valuemin":"0"},
                        {"aria-valuemax":"100"},{"data-toggle":"tooltip"},{"data-placement":"top"},
                        {"title":avgNumPro+"%"});
                $("#avgNumPro_div_show").append(div_4);
            }
            /**
			 * 填充侧边栏
             */
            function getPlaces() {
                $.ajax({
                    url: "${App_Path}/place/getAll",
                    dataType:"json"
                    , type: "GET"
                    , success: function (result) {
                        console.log(result);
                        //1.解析并填充侧边栏
                        $.each(result.extend.places, function(i,item) {
                            var placeid = item.placeid;
                            var li = $("<li></li>").addClass("nav-item");
                            var a = $("<a></a>").attr("href","#").attr("id",item.placeid);
                            a.click(function () {
                                getInfoByplaceid(item.placeid);
                            });
                            var _i = $("<i></i>").addClass("la la-dashboard");
                            var p = $("<p></p>").append(item.placename);
                            var span = $("<span></span>");

                            if(placeid == 1) {
                                span.addClass("badge badge-primary").append("1楼");
                            }
                            if(placeid == 2) {
                                span.addClass("badge badge-secondary").append("2楼");
                            }
                            if(placeid == 3) {
                                span.addClass("badge badge-success").append("3楼");
                            }
                            if(placeid == 4) {
                                span.addClass("badge badge-warning").append("4楼");
                            }
                            if(placeid == 5) {
                                span.addClass("badge badge-danger").append("5楼");
                            }
                            a.append(_i).append(p).append(span);
                            li.append(a).appendTo($("#sidebar"));
                        });
                    }
                });
            }

        });
    </script>
</head>
<body>
	<div class="wrapper">
		 <div class="main-header">
			<div class="logo-header">
				<a href="#" class="logo">
					图书馆人流量检测系统
				</a>
				<button class="navbar-toggler sidenav-toggler ml-auto" type="button" data-toggle="collapse" data-target="collapse" aria-controls="sidebar" aria-expanded="false" aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<button class="topbar-toggler more"><i class="la la-ellipsis-v"></i></button>
			</div>
			<nav class="navbar navbar-header navbar-expand-lg">
				<div class="container-fluid">
					
					<form class="navbar-left navbar-form nav-search mr-md-3" action="">
						<div class="input-group">
							<input type="text" placeholder="Search ..." class="form-control">
							<div class="input-group-append">
								<span class="input-group-text">
									<i class="la la-search search-icon"></i>
								</span>
							</div>
						</div>
					</form>
					</div>
				</nav>
			</div>
			<div class="sidebar">
				<div class="scrollbar-inner sidebar-wrapper">
					<div class="user">
						<div class="photo">
							<img src="${App_Path}/static/assets/img/profile.jpg">
						</div>
						<div class="info">
							<a class="" data-toggle="collapse" href="#collapseExample" aria-expanded="true">
								<span>
									林俊杰
									<span class="user-level">学生</span>
									<span class="caret"></span>
								</span>
							</a>
							<div class="clearfix"></div>

							<div class="collapse in" id="collapseExample" aria-expanded="true" style="">
								<ul class="nav">
									<li>
										<a href="#profile">
											<span class="link-collapse">My Profile</span>
										</a>
									</li>
									<li>
										<a href="#edit">
											<span class="link-collapse">Edit Profile</span>
										</a>
									</li>
									<li>
										<a href="#settings">
											<span class="link-collapse">Settings</span>
										</a>
									</li>
								</ul>
							</div>
						</div>
					</div>
					<ul class="nav" id="sidebar">
					</ul>
				</div>
			</div>
			<div class="main-panel">
				<div class="content">
					<div class="container-fluid">
						<%--<h4 class="page-title">图书馆当前人流量(1楼)</h4>--%>
						<div class="row">
							<div class="col-md-3">
								<div class="card card-stats card-warning">
									<div class="card-body ">
										<div class="row">
											<div class="col-5">
												<div class="icon-big text-center">
													<i class="la la-users"></i>
												</div>
											</div>
											<div class="col-7 d-flex align-items-center">
												<div class="numbers" id="curNum_div">
													<%--<p class="card-category">当前人数</p>--%>
													<%--<h4 class="card-title">1,294</h4>--%>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
							<div class="col-md-3">
								<div class="card card-stats card-success">
									<div class="card-body ">
										<div class="row">
											<div class="col-5">
												<div class="icon-big text-center">
													<i class="la la-users"></i>
												</div>
											</div>
											<div class="col-7 d-flex align-items-center">
												<div class="numbers" id="capacity_div">
													<%--<p class="card-category" >楼层容量</p>--%>
													<%--<h4 class="card-title">1,345</h4>--%>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
							<div class="col-md-3">
								<div class="card card-stats card-danger">
									<div class="card-body">
										<div class="row">
											<div class="col-5">
												<div class="icon-big text-center">
													<i class="la la-users"></i>
												</div>
											</div>
											<div class="col-7 d-flex align-items-center">
												<div class="numbers" id="maxNum_div">
													<%--<p class="card-category">今日最多人数</p>--%>
													<%--<h4 class="card-title">1,303</h4>--%>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
							<div class="col-md-3">
								<div class="card card-stats card-primary">
									<div class="card-body ">
										<div class="row">
											<div class="col-5">
												<div class="icon-big text-center">
													<i class="la la-users"></i>
												</div>
											</div>
											<div class="col-7 d-flex align-items-center">
												<div class="numbers"  id="minNum_div">
													<%--<p class="card-category">今日最少人数</p>--%>
													<%--<h4 class="card-title">576</h4>--%>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="row">
							<%--<div class="col-md-3">--%>
								<%--<div class="card">--%>
									<%--<div class="card-header">--%>
										<%--<h4 class="card-title">上座率</h4>--%>
										<%--<p class="card-category">单位/百分比(%)</p>--%>
									<%--</div>--%>
									<%--<div class="card-body">--%>
										<%--<div id="task-complete" class="chart-circle mt-4 mb-3"></div>--%>
									<%--</div>--%>
									<%--<div class="card-footer">--%>
										<%--<div class="legend"><i class="la la-circle text-primary"></i> Completed</div>--%>
									<%--</div>--%>
								<%--</div>--%>
							<%--</div>--%>
                                <div class="col-md-3">
                                    <div class="card card-stats">
                                        <div class="card-body">
                                            <p class="fw-bold mt-1">温馨提示</p>
                                            <div class="row">
                                                <div class="col-5">
                                                    <div class="icon-big text-center icon-warning">
                                                        <i class="la la-pie-chart text-warning"></i>
                                                    </div>
                                                </div>
                                                <div class="col-7 d-flex align-items-center">
                                                    <div class="numbers" id="attendance_div">
                                                        <p class="card-category">上座率</p>
                                                        <h4 class="card-title">70%</h4>
                                                    </div>
                                                </div>
                                            </div>
                                            <hr/>
                                            <div class="row">
                                                <div class="col-5">
                                                    <div class="icon-big text-center">
                                                        <i class="la la-heart-o text-primary"></i>
                                                    </div>
                                                </div>
                                                <div class="col-7 d-flex align-items-center">
                                                    <div class="numbers" id="clevel_div">
                                                        <p class="card-category">拥挤程度</p>
                                                        <h4 class="card-title">比较拥挤</h4>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
							<div class="col-md-5">
								<div class="card">
									<div class="card-body">
										<div class="progress-card">
											<div class="d-flex justify-content-between mb-1" id="attendance_cur_div">
												<span class="text-muted">当前人数占比(%)</span>
												<span class="text-muted fw-bold"> </span>
											</div>
											<div class="progress mb-2" style="height: 7px;" id="attendance_cur_div_show">
												<div class="progress-bar bg-success" role="progressbar" style="width:  ${attendance}%" aria-valuenow="78" aria-valuemin="0" aria-valuemax="100" data-toggle="tooltip" data-placement="top" title=" ${attendance}%"></div>
											</div>
										</div>
										<div class="progress-card">
											<div class="d-flex justify-content-between mb-1" id="maxNumPro_div">
												<span class="text-muted">今日最多人数占比(%)</span>
												<span class="text-muted fw-bold"> ${maxNumPro}%</span>
											</div>
											<div class="progress mb-2" style="height: 7px;" id="maxNumPro_div_show">
												<div class="progress-bar bg-info" role="progressbar" style="width: ${maxNumPro}%" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" data-toggle="tooltip" data-placement="top" title="${maxNumPro}%"></div>
											</div>
										</div>
										<div class="progress-card">
											<div class="d-flex justify-content-between mb-1" id="minNumPro_div">
												<span class="text-muted">今日最少人数占比(%)</span>
												<span class="text-muted fw-bold"> ${minNumPro}%</span>
											</div>
											<div class="progress mb-2" style="height: 7px;" id="minNumPro_div_show">
												<div class="progress-bar bg-primary" role="progressbar" style="width: ${minNumPro}%" aria-valuenow="70" aria-valuemin="0" aria-valuemax="100" data-toggle="tooltip" data-placement="top" title="${minNumPro}%"></div>
											</div>
										</div>
										<div class="progress-card">
											<div class="d-flex justify-content-between mb-1" id="avgNumPro_div">
												<span class="text-muted">平均人数占比(%)</span>
												<span class="text-muted fw-bold"> ${avgNumPro}%</span>
											</div>
											<div class="progress mb-2" style="height: 7px;" id="avgNumPro_div_show">
												<div class="progress-bar bg-warning" role="progressbar" style="width: ${avgNumPro}%" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" data-toggle="tooltip" data-placement="top" title="${avgNumPro}%"></div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
						<%--<div class="row">--%>
							<%--<div class="col-md-4">--%>
								<%--<div class="card">--%>
									<%--<div class="card-header">--%>
										<%--<h4 class="card-title">Users Statistics</h4>--%>
										<%--<p class="card-category">--%>
										<%--Users statistics this month</p>--%>
									<%--</div>--%>
									<%--<div class="card-body">--%>
										<%--<div id="monthlyChart" class="chart chart-pie"></div>--%>
									<%--</div>--%>
								<%--</div>--%>
							<%--</div>--%>
							<%--<div class="col-md-8">--%>
								<%--<div class="card">--%>
									<%--<div class="card-header">--%>
										<%--<h4 class="card-title">2018 Sales</h4>--%>
										<%--<p class="card-category">--%>
										<%--Number of products sold</p>--%>
									<%--</div>--%>
									<%--<div class="card-body">--%>
										<%--<div id="salesChart" class="chart"></div>--%>
									<%--</div>--%>
								<%--</div>--%>
							<%--</div>--%>
							<%--<div class="col-md-6">--%>
								<%--<div class="card">--%>
									<%--<div class="card-header ">--%>
										<%--<h4 class="card-title">Table</h4>--%>
										<%--<p class="card-category">Users Table</p>--%>
									<%--</div>--%>
									<%--<div class="card-body">--%>
										<%--<table class="table table-head-bg-success table-striped table-hover">--%>
											<%--<thead>--%>
												<%--<tr>--%>
													<%--<th scope="col">#</th>--%>
													<%--<th scope="col">First</th>--%>
													<%--<th scope="col">Last</th>--%>
													<%--<th scope="col">Handle</th>--%>
												<%--</tr>--%>
											<%--</thead>--%>
											<%--<tbody>--%>
												<%--<tr>--%>
													<%--<td>1</td>--%>
													<%--<td>Mark</td>--%>
													<%--<td>Otto</td>--%>
													<%--<td>@mdo</td>--%>
												<%--</tr>--%>
												<%--<tr>--%>
													<%--<td>2</td>--%>
													<%--<td>Jacob</td>--%>
													<%--<td>Thornton</td>--%>
													<%--<td>@fat</td>--%>
												<%--</tr>--%>
												<%--<tr>--%>
													<%--<td>3</td>--%>
													<%--<td colspan="2">Larry the Bird</td>--%>
													<%--<td>@twitter</td>--%>
												<%--</tr>--%>
											<%--</tbody>--%>
										<%--</table>--%>
									<%--</div>--%>
								<%--</div>--%>
							<%--</div>--%>
							<%--<div class="col-md-6">--%>
								<%--<div class="card card-tasks">--%>
									<%--<div class="card-header ">--%>
										<%--<h4 class="card-title">Tasks</h4>--%>
										<%--<p class="card-category">To Do List</p>--%>
									<%--</div>--%>
									<%--<div class="card-body ">--%>
										<%--<div class="table-full-width">--%>
											<%--<table class="table">--%>
												<%--<thead>--%>
													<%--<tr>--%>
														<%--<th>--%>
															<%--<div class="form-check">--%>
																<%--<label class="form-check-label">--%>
																	<%--<input class="form-check-input  select-all-checkbox" type="checkbox" data-select="checkbox" data-target=".task-select">--%>
																	<%--<span class="form-check-sign"></span>--%>
																<%--</label>--%>
															<%--</div>--%>
														<%--</th>--%>
														<%--<th>Task</th>--%>
														<%--<th>Action</th>--%>
													<%--</tr>--%>
												<%--</thead>--%>
												<%--<tbody>--%>
													<%--<tr>--%>
														<%--<td>--%>
															<%--<div class="form-check">--%>
																<%--<label class="form-check-label">--%>
																	<%--<input class="form-check-input task-select" type="checkbox">--%>
																	<%--<span class="form-check-sign"></span>--%>
																<%--</label>--%>
															<%--</div>--%>
														<%--</td>--%>
														<%--<td>Planning new project structure</td>--%>
														<%--<td class="td-actions text-right">--%>
															<%--<div class="form-button-action">--%>
																<%--<button type="button" data-toggle="tooltip" title="Edit Task" class="btn btn-link <btn-simple-primary">--%>
																	<%--<i class="la la-edit"></i>--%>
																<%--</button>--%>
																<%--<button type="button" data-toggle="tooltip" title="Remove" class="btn btn-link btn-simple-danger">--%>
																	<%--<i class="la la-times"></i>--%>
																<%--</button>--%>
															<%--</div>--%>
														<%--</td>--%>
													<%--</tr>--%>
													<%--<tr>--%>
														<%--<td>--%>
															<%--<div class="form-check">--%>
																<%--<label class="form-check-label">--%>
																	<%--<input class="form-check-input task-select" type="checkbox">--%>
																	<%--<span class="form-check-sign"></span>--%>
																<%--</label>--%>
															<%--</div>--%>
														<%--</td>--%>
														<%--<td>Update Fonts</td>--%>
														<%--<td class="td-actions text-right">--%>
															<%--<div class="form-button-action">--%>
																<%--<button type="button" data-toggle="tooltip" title="Edit Task" class="btn btn-link <btn-simple-primary">--%>
																	<%--<i class="la la-edit"></i>--%>
																<%--</button>--%>
																<%--<button type="button" data-toggle="tooltip" title="Remove" class="btn btn-link btn-simple-danger">--%>
																	<%--<i class="la la-times"></i>--%>
																<%--</button>--%>
															<%--</div>--%>
														<%--</td>--%>
													<%--</tr>--%>
													<%--<tr>--%>
														<%--<td>--%>
															<%--<div class="form-check">--%>
																<%--<label class="form-check-label">--%>
																	<%--<input class="form-check-input task-select" type="checkbox">--%>
																	<%--<span class="form-check-sign"></span>--%>
																<%--</label>--%>
															<%--</div>--%>
														<%--</td>--%>
														<%--<td>Add new Post--%>
														<%--</td>--%>
														<%--<td class="td-actions text-right">--%>
															<%--<div class="form-button-action">--%>
																<%--<button type="button" data-toggle="tooltip" title="Edit Task" class="btn btn-link <btn-simple-primary">--%>
																	<%--<i class="la la-edit"></i>--%>
																<%--</button>--%>
																<%--<button type="button" data-toggle="tooltip" title="Remove" class="btn btn-link btn-simple-danger">--%>
																	<%--<i class="la la-times"></i>--%>
																<%--</button>--%>
															<%--</div>--%>
														<%--</td>--%>
													<%--</tr>--%>
													<%--<tr>--%>
														<%--<td>--%>
															<%--<div class="form-check">--%>
																<%--<label class="form-check-label">--%>
																	<%--<input class="form-check-input task-select" type="checkbox">--%>
																	<%--<span class="form-check-sign"></span>--%>
																<%--</label>--%>
															<%--</div>--%>
														<%--</td>--%>
														<%--<td>Finalise the design proposal</td>--%>
														<%--<td class="td-actions text-right">--%>
															<%--<div class="form-button-action">--%>
																<%--<button type="button" data-toggle="tooltip" title="Edit Task" class="btn btn-link <btn-simple-primary">--%>
																	<%--<i class="la la-edit"></i>--%>
																<%--</button>--%>
																<%--<button type="button" data-toggle="tooltip" title="Remove" class="btn btn-link btn-simple-danger">--%>
																	<%--<i class="la la-times"></i>--%>
																<%--</button>--%>
															<%--</div>--%>
														<%--</td>--%>
													<%--</tr>--%>
												<%--</tbody>--%>
											<%--</table>--%>
										<%--</div>--%>
									<%--</div>--%>
									<%--<div class="card-footer ">--%>
										<%--<div class="stats">--%>
											<%--<i class="now-ui-icons loader_refresh spin"></i> Updated 3 minutes ago--%>
										<%--</div>--%>
									<%--</div>--%>
								<%--</div>--%>
							<%--</div>--%>
						<%--</div>--%>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
<script src="${App_Path}/static/assets/js/core/jquery.3.2.1.min.js"></script>
<script src="${App_Path}/static/assets/js/plugin/jquery-ui-1.12.1.custom/jquery-ui.min.js"></script>
<script src="${App_Path}/static/assets/js/core/popper.min.js"></script>
<script src="${App_Path}/static/assets/js/core/bootstrap.min.js"></script>
<script src="${App_Path}/static/assets/js/plugin/chartist/chartist.min.js"></script>
<script src="${App_Path}/static/assets/js/plugin/chartist/plugin/chartist-plugin-tooltip.min.js"></script>
<script src="${App_Path}/static/assets/js/plugin/bootstrap-notify/bootstrap-notify.min.js"></script>
<script src="${App_Path}/static/assets/js/plugin/bootstrap-toggle/bootstrap-toggle.min.js"></script>
<script src="${App_Path}/static/assets/js/plugin/jquery-mapael/jquery.mapael.min.js"></script>
<script src="${App_Path}/static/assets/js/plugin/jquery-mapael/maps/world_countries.min.js"></script>
<script src="${App_Path}/static/assets/js/plugin/chart-circle/circles.min.js"></script>
<script src="${App_Path}/static/assets/js/plugin/jquery-scrollbar/jquery.scrollbar.min.js"></script>
<script src="${App_Path}/static/assets/js/ready.min.js"></script>
<script src="${App_Path}/static/assets/js/demo.js"></script>
</html>