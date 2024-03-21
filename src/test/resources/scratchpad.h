int main(int argc, char *argv[])
{
    motion_device_task_creator.create_task(MD_task_execute, app_task_md_stk, APP_TASK_MD_PRIO, \
        "Motion Device Logic");
        
    return 0;
}