export class Reimbursement {
    id: number;
    authorId: number;
    authorName: string;
    resolverId: number;
    resolverName: string;
    status: number;
    type: number;
    amount: number;
    submitted: number;
    resolved: number;
    description: string;
    receipt: any;

    statusString(status: number) {
        if (status == 1) return "Pending";
        if (status == 2) return "Approved";
        else return "Denied";
    }

    typeString(type: number) {
        if (type == 1) return "Lodging";
        if (type == 2) return "Travel";
        if (type == 3) return "Food";
        else return "Other";
    }

    dateTimeToString(dateTime: number) {
        if (dateTime) return new Date(dateTime).toLocaleString();
        return "";
    }
}