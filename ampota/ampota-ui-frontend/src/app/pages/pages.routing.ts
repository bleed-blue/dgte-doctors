import { Routes, RouterModule } from '@angular/router';
import { ModuleWithProviders } from '@angular/core';
import { PagesComponent } from './pages.component';
import { BlankComponent } from './blank/blank.component';
import { SearchComponent } from './search/search.component';
import { ProjectComponent } from './project/project.component';
import { AuditComponent } from './audit/audit.component';
import { KnowYourCustomerComponent } from '@app/pages/kyc/kyc.component';

export const routes: Routes = [
    {
        path: '', 
        component: PagesComponent,
        children:[
            { path:'', redirectTo:'dashboard', pathMatch:'full' },
            { path: 'dashboard', loadChildren: 'app/pages/dashboard/dashboard.module#DashboardModule', data: { breadcrumb: 'Dashboard' }  },          
            { path: 'blank', component: BlankComponent, data: { breadcrumb: 'Blank page' } },
            { path: 'search', component: SearchComponent, data: { breadcrumb: 'Search' } },
            { path: 'proj', component: ProjectComponent, data: { breadcrumb: 'Project' } },
            { path: 'audit', component: AuditComponent, data: { breadcrumb: 'Audit Logs' } },
            { path: 'kyc', component: KnowYourCustomerComponent, data: { breadcrumb: 'Know Your Customer' } }
       ]
    }
];

export const routing: ModuleWithProviders = RouterModule.forChild(routes);