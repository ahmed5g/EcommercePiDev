import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListdashComponent } from './listdash.component';

describe('ListdashComponent', () => {
  let component: ListdashComponent;
  let fixture: ComponentFixture<ListdashComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListdashComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListdashComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
