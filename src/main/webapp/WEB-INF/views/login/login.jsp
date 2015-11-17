<md-content layout-fill layout="column" layout-align="center center" >
	<md-toolbar flex class = "md-padding md-whiteframe-glow-z1 site-content-toolbar" >
		<span class="md-headline"> Sign In </span>
	</md-toolbar>
	<md-card class="md-padding" layout="column" >
		<div style="min-width:600px;">
			<md-toolbar style="border-radius: 5px">
				<div class="md-toolbar-tools">
					<div class="md-headline">login</div> 
			    </div>
			</md-toolbar>
			<md-input-container> 
				<label>Id</label> 
				<input ng-model="user.id"> 
			</md-input-container>
			<md-input-container> 
				<label>Password</label> 
				<input ng-model="user.passwd" type="password"> 
			</md-input-container>
			<section layout="row"  layout-align="center center" layout-wrap>
				<md-button class="md-raised md-primary" ng-click="signIn()">Sign In</md-button>
				<md-button class="md-raised md-primary" ng-click="movePage('/signUp')" >Sign Up </md-button>
			</section>
		</div>
	</md-card>
</md-content>
