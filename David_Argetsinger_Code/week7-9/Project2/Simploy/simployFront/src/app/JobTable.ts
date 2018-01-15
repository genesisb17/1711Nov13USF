import { User } from "./user";
export class JobTable {
    jobId: number;
    company: string;
    description: string;
    postDate: string;
    title: string;
    skills: string;
    location:string;
    user: User;
    constructor (){};
}