export class video
{
    id: number;
    title: string;
    videoCode:string;
    desc:string;
    constructor(id:number,title:string,videoCode:string,desc:string)
    {
        this.id=id;
        this.title=title;
        this.desc=desc;
        this.videoCode=videoCode;
    }
}