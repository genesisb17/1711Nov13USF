export class Reimbursement{
    id: number;
    authorId: number;
    resolverId: number;
    status: number;
    type: number;
    amount: number;
    submitted: number;
    resolved: number;
    description: string;
    receipt: any;
}