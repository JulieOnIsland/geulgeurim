import Box from "@mui/material/Box"

import WorksEdit from "../works/works-edit";

type Props = {
  id: string;
};


export default function ResumeDetailView({ id }: Props) {
  return (
    <Box>
      <WorksEdit workId={id}/>
    </Box>
  )
}
