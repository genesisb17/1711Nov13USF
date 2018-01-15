import { Skills } from "./Skills";
import { Projects } from "./Projects";
import { Certifications } from "./Certifications";
import { Educations } from "./Educations";

export class Resume {
    user_id:number;
    resid:number;
    description:string;
    skill : Skills[] = [];
    //needs get by rID
    project : Projects[] = [];
    //needs get by rid
    certification : Certifications[] = [];
    //needs get by rid  
    education: Educations[] = [];
    //
    constructor () {};

}