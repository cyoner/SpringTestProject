<md-content layout-fill layout="column" layout-align="center center" >
	<md-toolbar flex class = "md-padding md-whiteframe-glow-z1 site-content-toolbar" >
		<span class="md-headline"> Update User </span>
	</md-toolbar>
	<md-card class="md-padding" layout="column" >
	
	
		<div style="min-width:600px;">
			<md-toolbar style="border-radius: 5px">
				<div class="md-toolbar-tools">
					<div class="md-headline">Update User</div> 
			    </div>
			</md-toolbar>
			<md-input-container> 
				<label>Id</label> 
				<input ng-model="user.id"> 
			</md-input-container>
			
			<md-button class="md-raised md-primary" ng-click="getUser()">get User</md-button>
			
			<md-input-container> 
				<label>Password</label> 
				<input type="password" ng-model="user.passwd"> 
			</md-input-container>
	
			<md-input-container> 
				<label>first_name</label> 
				<input ng-model="user.first_name"> 
			</md-input-container>
			
			<md-input-container> 
				<label>last_name</label> 
				<input ng-model="user.last_name"> 
			</md-input-container>
			
			<section layout="row"  layout-align="center center" layout-wrap>
				<md-button class="md-raised md-primary" ng-click="updateUserInfo()">Update User Info</md-button>
			</section>
		</div>
	</md-card>
</md-content>

