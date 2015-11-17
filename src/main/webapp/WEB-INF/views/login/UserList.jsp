<md-content layout-fill layout="column" layout-align="center center" >
	
	<md-toolbar flex class = "md-padding md-whiteframe-glow-z1 site-content-toolbar" >
		<span class="md-headline"> User List </span>
	</md-toolbar>
	
	<md-card class="md-padding" layout="column" ng-init="getUserList()">
		<div style="min-width:600px;">
			<md-toolbar style="border-radius: 5px">
				<div class="md-toolbar-tools">
					<div class="md-headline">User List</div> 
			    </div>
			</md-toolbar>
				
			<div flex layout='row' layout-padding layout-align="start center" >
				<div flex class="md-headline">id</div>				
				<div flex class="md-headline">first_name</div>		
				<div flex class="md-headline">last_name</div>
				
			</div>

			<div ng-repeat='user in userList' class="row">
				<div flex layout='row' layout-padding layout-align="start center" ng-click="showUserDetail(user,$event)">
					<div flex> {{user.id}} </div>
					<div flex> {{user.first_name}} </div>
					<div flex> {{user.last_name}} </div>
				</div>
			</div>
		</div>
	</md-card>
</md-content>
