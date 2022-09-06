import { GradesPageComponent } from './components/grades-page/grades-page.component';
import { StudentsComponent } from './components/students/students.component';
import { GradesComponent } from './components/grades/grades.component';
import { NgModule, Component } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  { path: 'grades', component: GradesPageComponent },
  { path: 'students-page', component: StudentsComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
