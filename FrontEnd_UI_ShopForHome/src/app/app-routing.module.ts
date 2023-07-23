import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminLoginComponent } from './admin-login/admin-login.component';
import { AdminPageComponent } from './admin-page/admin-page.component';
import { AdminComponent } from './admin/admin.component';
import { CartItemComponent } from './cart-item/cart-item.component';
import { CreateProductComponent } from './create-product/create-product.component';
import { DiscountComponent } from './discount/discount.component';
import { FileUploadComponent } from './file-upload/file-upload.component';
import { HomeComponent } from './home/home.component';
import { PaymentComponent } from './payment/payment.component';
import { PdpComponent } from './pdp/pdp.component';
import { AuthGuard } from './shared/auth.guard';
import { UserGuard } from './shared/user.guard';
import { UpdateProductComponent } from './update-product/update-product.component';
import { UpdateUserComponent } from './update-user/update-user.component';
import { UserLoginComponent } from './user-login/user-login.component';
import { UserPageComponent } from './user-page/user-page.component';
import { UserregisterComponent } from './userregister/userregister.component';
import { UsersComponent } from './users/users.component';
import { WishlistComponent } from './wishlist/wishlist.component';

const routes: Routes = [
  {path:"",component:HomeComponent},
  {path:"admin-page/productList",component:PdpComponent,canActivate:[AuthGuard]},
  {path:"update-product/:id",component:UpdateProductComponent ,canActivate:[AuthGuard]},
  {path:"admin-page/productList/create-product",component:CreateProductComponent,canActivate:[AuthGuard]},
  {path:"home",component:HomeComponent},
  {path:"admin-page/file-upload",component:FileUploadComponent ,canActivate:[AuthGuard]},
  {path:"user-login/user-register",component:UserregisterComponent},
  {path:"admin-page/userList",component:UsersComponent ,canActivate:[AuthGuard]},
  {path:"admin-page/userList/create-user",component:UserregisterComponent ,canActivate:[AuthGuard]},
  {path:"update-user/:id",component:UpdateUserComponent ,canActivate:[AuthGuard]},
  {path:"user-login",component:UserLoginComponent},
  {path:"admin-login",component:AdminLoginComponent},
  {path:"admin-page",component:AdminPageComponent,canActivate:[AuthGuard]},
  {path:"user-page/:id",component:UserPageComponent, canActivate:[UserGuard]},
  {path:"wishlist/:id",component:WishlistComponent, canActivate:[UserGuard]},
  {path:"bulk-upload",component:FileUploadComponent ,canActivate:[AuthGuard]},
  {path:"admin-page/reg-admin",component:AdminComponent, canActivate:[AuthGuard]},
  {path:"cart/:uid",component:CartItemComponent},
  {path:"discount",component:DiscountComponent,canActivate:[UserGuard]},
  {path:"payment/:total",component:PaymentComponent}


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
